package com.booking.movie.repository;

import com.booking.movie.dto.ShowResponse;
import com.booking.movie.entity.ShowDetails;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ShowQueryRepository extends Repository<ShowDetails,Long> {

    @Query("""
        SELECT new com.booking.movie.dto.ShowResponse(
            s.showId,
            m.title,
            t.name,
            sc.name,
            s.showDate,
            s.showTime
        )
        FROM ShowDetails s
        JOIN s.movie m
        JOIN s.screen sc
        JOIN sc.theatre t
        WHERE s.isActive = true
    """)
    List<ShowResponse> findAllShows();

    @Query("""
        SELECT new com.booking.movie.dto.ShowResponse(
            s.showId,
            m.title,
            t.name,
            sc.name,
            s.showDate,
            s.showTime
        )
        FROM ShowDetails s
        JOIN s.movie m
        JOIN s.screen sc
        JOIN sc.theatre t
        WHERE t.theatreId = :theatreId
          AND s.showDate >= :fromDate
          AND s.showTime >= :fromTime
          AND s.isActive = true
    """)
    List<ShowResponse> findByTheatre(@Param("theatreId") Long TheatreId, @Param("fromDate") LocalDate fromDate, @Param("fromTime") LocalTime fromTime);
}
