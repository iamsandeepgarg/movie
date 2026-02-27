package com.booking.movie.service;

import com.booking.movie.dto.TheatreResponse;
import com.booking.movie.entity.Theatre;
import com.booking.movie.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
