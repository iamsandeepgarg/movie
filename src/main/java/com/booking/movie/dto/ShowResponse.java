package com.booking.movie.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ShowResponse(
        Long showId,
        String movieTitle,
        String TheatreName,
        String screenName,
        LocalDate showDate,
        LocalTime showTime
) {
}
