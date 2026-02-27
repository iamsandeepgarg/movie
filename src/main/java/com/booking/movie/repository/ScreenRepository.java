package com.booking.movie.repository;

import com.booking.movie.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {

    @Query("""
   SELECT s FROM Screen s
   JOIN FETCH s.theatre t
   WHERE t.theatreId = :theatreId
""")
    List<Screen> findByTheatreWithTheatre(Long theatreId);
}
