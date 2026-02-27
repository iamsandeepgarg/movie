package com.booking.movie.repository;

import com.booking.movie.entity.BookingSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingSeatRepository extends JpaRepository<BookingSeat,Long> {
}
