package com.booking.movie.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ShowRequest(
    Long movieId,
    Long screenId,
    LocalDate showDate,
    LocalTime showTime
) {
}
