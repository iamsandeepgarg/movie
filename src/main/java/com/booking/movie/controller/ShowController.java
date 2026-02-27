package com.booking.movie.controller;

import com.booking.movie.dto.ShowRequest;
import com.booking.movie.dto.ShowResponse;
import com.booking.movie.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;


    @PostMapping("/")
    public ResponseEntity<Long> saveShow(@RequestBody ShowRequest showRequest){
        return ResponseEntity.ok(showService.saveShow(showRequest));
    }

    @GetMapping("/")
    public ResponseEntity<List<ShowResponse>> getAllShows(){

         return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/theatre/{theatreId}")
    public ResponseEntity<List<ShowResponse>> getShowByTheatre(@PathVariable Long theatreId){
        return ResponseEntity.ok(showService.getByTheatre(theatreId));
    }

    @DeleteMapping("/{showId}")
    public void deactivateShow(@PathVariable Long showId){
        showService.deactivaShow(showId);
    }
}
