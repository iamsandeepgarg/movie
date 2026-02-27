package com.booking.movie.controller;

import com.booking.movie.dto.TheatreResponse;
import com.booking.movie.entity.Theatre;
import com.booking.movie.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;

    @PostMapping("/")
    public Theatre add(@RequestBody Theatre theatre){
        System.out.println(theatre);
        return theatreService.addTheatre(theatre);
    }

    @GetMapping("/")
    public List<TheatreResponse> getAll(){
        return theatreService.getAll();
    }

    @GetMapping("/city/{city}")
    public List<TheatreResponse> getByCity(@PathVariable String city){
        return theatreService.findByCity(city);
    }

}
