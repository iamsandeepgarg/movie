package com.booking.movie.service;

import com.booking.movie.dto.*;
import com.booking.movie.entity.Theatre;
import com.booking.movie.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TheatreService {

    private final TheatreRepository theatreRepository;

    public Theatre addTheatre(Theatre theatre){
        return theatreRepository.save(theatre);
    }

    public List<TheatreResponse> getAll(){
        List<Theatre> theatres = theatreRepository.findAll();
        return theatres.stream().map(t -> new TheatreResponse(
                t.getTheatreId(), t.getName(), t.getAddress(), t.getCity(), t.getState(), t.getLatitude(), t.getLongitude(), t.getScreenCount()
        )).toList();

    }

    public List<TheatreResponse> findByCity(String city){
        List<Theatre> cities = theatreRepository.findByCityIgnoreCase(city);
        System.out.println("Hello");
        System.out.println(cities);
        return cities.stream().map(c-> new TheatreResponse(
                c.getTheatreId(), c.getName(), c.getAddress(), c.getCity(), c.getState(), c.getLatitude(), c.getLongitude(), c.getScreenCount()
        )).toList();
    }

    public List<TheatreShowResponse> findTheatreShowByCityMovieAndDate(String city, Long movieId, LocalDate showDate){
        List<TheatreShowFlatResponse> theatreList = theatreRepository.findTheatreShowByMovieAndDateAndCity(movieId,showDate,city);

        Map<Long,TheatreShowResponse> map = new LinkedHashMap<>();

        for (TheatreShowFlatResponse t : theatreList ){

            TheatreShowResponse theatreShowResponse = map.computeIfAbsent(t.theatreId(),
                    id -> new TheatreShowResponse(t.theatreId(), t.name(), t.address(), t.city(), new ArrayList<>()));

            theatreShowResponse.showTime()
                    .add(new ShowTimeResponse(t.showId(), t.showTime()));
        }

        return  new ArrayList<>(map.values());

    }


}
