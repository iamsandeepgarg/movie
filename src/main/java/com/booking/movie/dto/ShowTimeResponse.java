package com.booking.movie.dto;

import java.time.LocalTime;

public record ShowTimeResponse(
        Long showId,
        LocalTime showTime
) {
}
