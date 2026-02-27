package com.booking.movie.service;

import com.booking.movie.dto.ScreenRequest;
import com.booking.movie.dto.ScreenResponse;
import com.booking.movie.entity.Screen;
import com.booking.movie.entity.Theatre;
import com.booking.movie.repository.ScreenRepository;
import com.booking.movie.repository.TheatreRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    public ScreenResponse saveScreen(ScreenRequest screenRequest){

        Theatre theatre = theatreRepository.findById(screenRequest.theatreId())
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        Screen screen = Screen.builder()
                .name(screenRequest.name())
                .seatingCapacity(screenRequest.seatingCapacity())
                .screenType(screenRequest.screenType())
                .theatre(theatre)
                .build();
        Screen savedScreen = screenRepository.save(screen);

        return toResponse(savedScreen);

    }

    public List<ScreenResponse> getByTheatre(Long theatreId){

        List<Screen> screens = screenRepository.findByTheatreWithTheatre(theatreId);
        return screens.stream().map(s -> toResponse(s)).toList();
    }

    public ScreenResponse toResponse(Screen screen){
        return new ScreenResponse(
                screen.getScreenId(),
                screen.getName(),
                screen.getSeatingCapacity(),
                screen.getScreenType(),
                screen.getTheatre().getTheatreId(),
                screen.getTheatre().getName()
        );
    }


}
