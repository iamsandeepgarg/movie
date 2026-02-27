package com.booking.movie.repository;

import com.booking.movie.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

//    List<Seat> findBySeatId(Long seatId);
//
//    List<Seat> findBySeatIdAndIsBookedFalse(Long showId);
}
