package com.booking.movie.controller;

import com.booking.movie.dto.ShowRequest;
import com.booking.movie.dto.ShowResponse;
import com.booking.movie.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;


    @PostMapping("/")
    public Long saveShow(@RequestBody ShowRequest showRequest){
        return showService.saveShow(showRequest);
    }

    @GetMapping("/")
    public List<ShowResponse> getAllShows(){
        return showService.getAllShows();
    }

    @GetMapping("/theatre/{theatreId}")
    public List<ShowResponse> getShowByTheatre(@PathVariable Long theatreId){
        return showService.getByTheatre(theatreId);
    }

    @DeleteMapping("/{showId}")
    public void deactivateShow(@PathVariable Long showId){
        showService.deactivaShow(showId);
    }
}
