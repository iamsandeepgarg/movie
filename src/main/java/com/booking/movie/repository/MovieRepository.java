package com.booking.movie.repository;

import com.booking.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByLanguageIgnoreCase(String language);

    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByActiveTrue();
}
