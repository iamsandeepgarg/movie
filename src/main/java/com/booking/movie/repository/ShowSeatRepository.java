package com.booking.movie.repository;

import com.booking.movie.entity.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        SELECT ss
        FROM ShowSeat ss
        WHERE ss.show.showId = :showId
        AND ss.showSeatId IN :seatIds
    """)
    List<ShowSeat> lockSeats(
            @Param("showId") Long showId,
            @Param("seatIds") List<Long> seatIds
    );
}
