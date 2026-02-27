package com.booking.movie.controller;

import com.booking.movie.dto.TheatreResponse;
import com.booking.movie.dto.TheatreShowResponse;
import com.booking.movie.entity.Theatre;
import com.booking.movie.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/theatres")
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;

    @PostMapping("/")
    public ResponseEntity<Theatre> add(@RequestBody Theatre theatre){
        System.out.println(theatre);
        return ResponseEntity.ok(theatreService.addTheatre(theatre));
    }

    @GetMapping("/")
    public ResponseEntity<List<TheatreResponse>> getAll(){
        return ResponseEntity.ok(theatreService.getAll());
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<TheatreResponse>> getByCity(@PathVariable String city){
        return ResponseEntity.ok(theatreService.findByCity(city));
    }

    @GetMapping("/movie/{movieId}/city/{city}/date/{showDate}")
    public ResponseEntity<List<TheatreShowResponse>> getByCityMovieAndDate(@PathVariable String city, @PathVariable Long movieId, @PathVariable LocalDate showDate){
        return ResponseEntity.ok(theatreService.findTheatreShowByCityMovieAndDate(city,movieId,showDate));
    }

}
