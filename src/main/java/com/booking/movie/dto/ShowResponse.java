package com.booking.movie.dto;

import java.time.LocalDateTime;

public record ShowResponse(
        Long showId,
        String movieTitle,
        String TheatreName,
        String screenName,
        LocalDateTime showTime
) {
}
