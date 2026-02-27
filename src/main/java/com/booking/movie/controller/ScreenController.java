package com.booking.movie.controller;

import com.booking.movie.dto.ScreenRequest;
import com.booking.movie.dto.ScreenResponse;
import com.booking.movie.service.ScreenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @PostMapping("/")
    public ScreenResponse saveScreen(@Valid @RequestBody ScreenRequest screenRequest){

        ScreenResponse screenResponse = screenService.saveScreen(screenRequest);
        return  screenResponse;
    }

    @GetMapping("/theatre/{theatreId}")
    public List<ScreenResponse> getScreenByTheatreId(@PathVariable Long theatreId){
        List<ScreenResponse> screens = screenService.getByTheatre(theatreId);
        return screens;
    }



}
