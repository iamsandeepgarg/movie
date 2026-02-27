package com.booking.movie.dto;

import java.util.List;

public record SeatHoldRequest(
        Long userId,
        Long showId,
        List<Long> seatIds
) {
}
