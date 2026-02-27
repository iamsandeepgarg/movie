package com.booking.movie.controller;

import com.booking.movie.dto.MovieRequest;
import com.booking.movie.dto.MovieResponse;
import com.booking.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/")
    public MovieResponse saveMovie(@RequestBody MovieRequest movieRequest){
        return movieService.saveMovie(movieRequest);
    }

    @GetMapping("/")
    public List<MovieResponse> getAllMovies(){
        return movieService.getAllMovies();
    }


    @GetMapping("/language/{language}")
    public List<MovieResponse> getMoviesByLanguage(@PathVariable String language){
        return movieService.getMoviesByLanguage(language);
    }



    
}
