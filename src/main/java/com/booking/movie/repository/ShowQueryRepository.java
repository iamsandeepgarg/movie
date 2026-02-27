package com.booking.movie.repository;

import com.booking.movie.dto.ShowResponse;
import com.booking.movie.entity.Show;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ShowQueryRepository extends Repository<Show,Long> {

    @Query("""
        SELECT new com.booking.movie.dto.ShowResponse(
            s.showId,
            m.title,
            t.name,
            sc.name,
            s.showTime
        )
        FROM Show s
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
            s.showTime
        )
        FROM Show s
        JOIN s.movie m
        JOIN s.screen sc
        JOIN sc.theatre t
        WHERE t.theatreId = :theatreId
          AND s.showTime >= :fromTime
          AND s.isActive = true
    """)
    List<ShowResponse> findByTheatre(@Param("theatreId") Long TheatreId, @Param("fromTime") LocalDateTime fromTime);
}
