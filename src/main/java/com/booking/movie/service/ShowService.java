package com.booking.movie.service;

import com.booking.movie.dto.ShowRequest;
import com.booking.movie.dto.ShowResponse;
import com.booking.movie.entity.Movie;
import com.booking.movie.entity.Screen;
import com.booking.movie.entity.Show;
import com.booking.movie.repository.MovieRepository;
import com.booking.movie.repository.ScreenRepository;
import com.booking.movie.repository.ShowQueryRepository;
import com.booking.movie.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;
    private final ShowQueryRepository showQueryRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

    @Transactional
    public Long saveShow(ShowRequest showRequest){

        Movie movie = movieRepository.findById(showRequest.movieId())
                .orElseThrow(()-> new IllegalArgumentException("Movie not found"));

        Screen screen = screenRepository.findById(showRequest.screenId())
                .orElseThrow(()-> new IllegalArgumentException("Screen not found"));

        Show show = Show.builder()
                .movie(movie)
                .screen(screen)
                .showTime(showRequest.showTime())
                .isActive(true)
                .build();

        showRepository.save(show);

        return show.getShowId();
    }

    @Transactional(readOnly = true)
    public List<ShowResponse> getAllShows(){
        return showQueryRepository.findAllShows();
    }

    @Transactional(readOnly = true)
    public List<ShowResponse> getByTheatre(Long theatreId){
        return  showQueryRepository.findByTheatre(theatreId, LocalDateTime.now());
    }

    @Transactional
    public void deactivaShow(Long showId){
        Show show = showRepository.findById(showId)
                .orElseThrow(()-> new IllegalArgumentException("Show not found"));

        show.setIsActive(false);
    }





}




