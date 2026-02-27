package com.booking.movie.repository;

import com.booking.movie.dto.TheatreShowFlatResponse;
import com.booking.movie.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Long> {

    List<Theatre> findByCityIgnoreCase(String city);

    @Query("""
            select new com.booking.movie.dto.TheatreShowFlatResponse(
                 t.theatreId,
                 t.name,
                 t.address,
                 t.city,
                 s.showId,
                 s.showTime
                 )
            from ShowDetails s
            join s.screen sc
            join sc.theatre t
            where t.city = :city
            and s.showDate = :showDate
            and s.isActive = true
            and s.movie.movieId = :movieId
    """)
    List<TheatreShowFlatResponse> findTheatreShowByMovieAndDateAndCity(
            @Param("movieId") Long movieId,
            @Param("showDate") LocalDate showDate,
            @Param("city") String city
    );

}
