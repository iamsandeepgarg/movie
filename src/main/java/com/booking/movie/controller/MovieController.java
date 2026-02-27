package com.booking.movie.controller;

import com.booking.movie.dto.MovieRequest;
import com.booking.movie.dto.MovieResponse;
import com.booking.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/")
    public ResponseEntity<MovieResponse> saveMovie(@RequestBody MovieRequest movieRequest){
        return ResponseEntity.ok(movieService.saveMovie(movieRequest));
    }

    @GetMapping("/")
    public ResponseEntity<List<MovieResponse>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }


    @GetMapping("/language/{language}")
    public ResponseEntity<List<MovieResponse>> getMoviesByLanguage(@PathVariable String language){
        return ResponseEntity.ok(movieService.getMoviesByLanguage(language));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<MovieResponse>> getMoviesByCity(@PathVariable String city){
        return ResponseEntity.ok(movieService.getMoviesByCity(city));
    }
}
