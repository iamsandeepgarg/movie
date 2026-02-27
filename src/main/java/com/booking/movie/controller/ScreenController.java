package com.booking.movie.controller;

import com.booking.movie.dto.ScreenRequest;
import com.booking.movie.dto.ScreenResponse;
import com.booking.movie.service.ScreenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @PostMapping("/")
    public ResponseEntity<ScreenResponse> saveScreen(@Valid @RequestBody ScreenRequest screenRequest){

        ScreenResponse screenResponse = screenService.saveScreen(screenRequest);
        return ResponseEntity.ok(screenResponse);
    }

    @GetMapping("/theatre/{theatreId}")
    public ResponseEntity<List<ScreenResponse>> getScreenByTheatreId(@PathVariable Long theatreId){
        List<ScreenResponse> screens = screenService.getByTheatre(theatreId);
        return ResponseEntity.ok(screens);
    }



}
