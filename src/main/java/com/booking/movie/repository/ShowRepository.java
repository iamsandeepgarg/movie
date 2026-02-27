package com.booking.movie.repository;

import com.booking.movie.entity.ShowDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<ShowDetails,Long> {

}
