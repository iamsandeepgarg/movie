package com.booking.movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ScreenRequest(
        @NotBlank String name,
        @NotNull Integer seatingCapacity,
        String screenType,
        @NotNull Long theatreId
) {
}
