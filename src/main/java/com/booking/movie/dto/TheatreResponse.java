package com.booking.movie.dto;

public record TheatreResponse(
        Long theatreId,
        String name,
        String address,
        String city,
        String state,
        Double latitude,
        Double longitude,
        Integer screenCount
) {
}
