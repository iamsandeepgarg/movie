package com.booking.movie.dto;

public record ScreenResponse(
        Long screenId,
        String name,
        Integer seatingCapacity,
        String screenType,
        Long theatreId,
        String theatreName
) {
}
