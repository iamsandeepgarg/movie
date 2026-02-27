package com.booking.movie.service;

import com.booking.movie.dto.MovieRequest;
import com.booking.movie.dto.MovieResponse;
import com.booking.movie.entity.Movie;
import com.booking.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieResponse saveMovie(MovieRequest movieRequest){

        Movie movie = Movie.builder()
                .title(movieRequest.title())
                .language(movieRequest.language())
                .genre(movieRequest.genre())
                .durationMinutes(movieRequest.durationMinutes())
                .certificate(movieRequest.certificate())
                .active(true)
                .build();

        Movie savedMovie = movieRepository.save(movie);

        return toResponse(savedMovie);

    }

    public List<MovieResponse> getAllMovies(){
        List<Movie> movies = movieRepository.findByActiveTrue();
        return movies.stream().map(this::toResponse).toList();
    }

    public List<MovieResponse> getMoviesByLanguage(String language){
        List<Movie> movies = movieRepository.findByLanguageIgnoreCase(language);
        return movies.stream().map(t-> toResponse(t) ).toList();
    }

    private MovieResponse toResponse(Movie m) {
        return new MovieResponse(
                m.getMovieId(),
                m.getTitle(),
                m.getLanguage(),
                m.getGenre(),
                m.getDurationMinutes(),
                m.getCertificate()
        );
    }
}
