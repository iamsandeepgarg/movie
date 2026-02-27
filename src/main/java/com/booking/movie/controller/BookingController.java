package com.booking.movie.controller;

import com.booking.movie.dto.BookingRequest;
import com.booking.movie.dto.BookingResponse;
import com.booking.movie.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/")
    public BookingResponse bookSeat(@RequestBody BookingRequest bookingRequest){
        return bookingService.bookSeats(bookingRequest);
    }

}
