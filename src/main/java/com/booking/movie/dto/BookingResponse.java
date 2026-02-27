package com.booking.movie.dto;

import java.math.BigDecimal;
import java.util.List;

public record BookingResponse(
        Long bookingId,
        BigDecimal totalAmount,
        String status,
        List<Long> seatIds
) {
}
