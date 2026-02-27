package com.booking.movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovieRequest(
        @NotBlank String title,
        @NotBlank String language,
        String genre,
        @NotNull Integer durationMinutes,
        String certificate
) {
}
