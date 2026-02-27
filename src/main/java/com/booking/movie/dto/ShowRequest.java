package com.booking.movie.dto;

import java.time.LocalDateTime;

public record ShowRequest(
    Long movieId,
    Long screenId,
    LocalDateTime showTime
) {
}
