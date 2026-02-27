package com.booking.movie.dto;

import java.util.List;

public record BookingRequest(
        Long userId,
        Long showId,
        List<Long> showSeatIds
) {
}
