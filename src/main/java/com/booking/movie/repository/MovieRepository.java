package com.booking.movie.repository;

import com.booking.movie.dto.MovieResponse;
import com.booking.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByLanguageIgnoreCase(String language);

    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByActiveTrue();

    @Query("""
select distinct new com.booking.movie.dto.MovieResponse(
    m.movieId,
    m.title,
    m.language,
    m.genre,
    m.durationMinutes,
    m.certificate
)
from ShowDetails s
join s.movie m
join s.screen sc
join sc.theatre t
where t.city = :city
and s.showDate >= current_date
and s.isActive = true
""")
    List<MovieResponse> findByCity(@Param("city") String city);
}
