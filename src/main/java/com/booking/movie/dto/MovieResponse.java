package com.booking.movie.dto;

public record MovieResponse(
        Long movieId,
        String title,
        String language,
        String genre,
        Integer durationMinutes,
        String certificate
) {
}
