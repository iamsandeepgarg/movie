package com.booking.movie.dto;

import java.util.List;

public record TheatreShowResponse(
        Long theatreId,
        String name,
        String address,
        String city,
        List<ShowTimeResponse> showTime

) {
}
