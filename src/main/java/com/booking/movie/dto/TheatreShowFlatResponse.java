package com.booking.movie.dto;

import java.time.LocalTime;

public record TheatreShowFlatResponse(
        Long theatreId,
        String name,
        String address,
        String city,
        Long showId,
        LocalTime showTime
) {
}
