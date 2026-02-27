package com.booking.movie.service;

import com.booking.movie.dto.BookingRequest;
import com.booking.movie.dto.BookingResponse;
import com.booking.movie.entity.*;
import com.booking.movie.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookingService {

    private final ShowSeatRepository showSeatRepository;
    private final BookingRepository bookingRepository;
    private final BookingSeatRepository bookingSeatRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final StringRedisTemplate stringRedisTemplate;

    @Transactional
    public BookingResponse bookSeats(BookingRequest bookingRequest){

        User user = userRepository.findById(bookingRequest.userId())
                .orElseThrow(()->new IllegalArgumentException("User Not found"));

        Show show = showRepository.findById(bookingRequest.showId())
                .orElseThrow(()->new IllegalArgumentException("Show not found"));

        //Validate Redis lock
        for (Long seatId : bookingRequest.showSeatIds()){
            String key =buildKey(bookingRequest.showId(),seatId);
            if(!stringRedisTemplate.hasKey(key)){
                throw new RuntimeException("Seat lock expiered" + bookingRequest.showSeatIds());
            }
        }

        // Lock DB Rows
        List<ShowSeat> showSeats = showSeatRepository.lockSeats(bookingRequest.showId(), bookingRequest.showSeatIds());

        // validate invalid seats
        if(showSeats.size() != bookingRequest.showSeatIds().size()){
            throw new RuntimeException("Invalid Seats");
        }

        // validate the requested seats are available
        for(ShowSeat s : showSeats){
            if(s.getStatus() != SeatStatus.AVAILABLE){
                throw new RuntimeException("Seat already booked: " + s.getShowSeatId());
            }
        }

        //Booking seats

        BigDecimal totalAmount = showSeats.stream()
                .map(showSeat -> showSeat.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .totalAmount(totalAmount)
                .status(BookingStatus.CONFIRMED)
                .build();

        bookingRepository.save(booking);

        //Marking seat as booked

        for(ShowSeat s : showSeats){
            s.setStatus(SeatStatus.BOOKED);

            BookingSeat bookingSeat = BookingSeat.builder()
                    .showSeat(s)
                    .booking(booking)
                    .price(s.getPrice())
                    .build();
            bookingSeatRepository.save(bookingSeat);
        }
        //unlock redis seats
        List<String> keys = bookingRequest.showSeatIds()
                .stream()
                .map(id -> buildKey(bookingRequest.showId(), id))
                .toList();

        stringRedisTemplate.delete(keys);

        return new BookingResponse(booking.getBookingId(), totalAmount, booking.getStatus().name(), bookingRequest.showSeatIds() );
    }

    private String buildKey(Long showId, Long seatId){
        return "seat:"+ showId + ":" + seatId;

    }
}
