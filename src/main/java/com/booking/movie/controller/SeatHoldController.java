package com.booking.movie.controller;

import com.booking.movie.dto.SeatHoldRequest;
import com.booking.movie.service.SeatHoldService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holds")
@RequiredArgsConstructor
public class SeatHoldController {
    private final SeatHoldService seatHoldService;

    @PostMapping("/")
    public String holdSeats(@RequestBody SeatHoldRequest seatHoldRequest){
        seatHoldService.holdSeats(seatHoldRequest);
        return "Seats hold for 5 Mins";
    }
}
