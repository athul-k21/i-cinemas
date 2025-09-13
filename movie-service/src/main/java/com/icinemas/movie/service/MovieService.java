package com.icinemas.movie.service;

import com.icinemas.dto.MovieDTO;
import com.icinemas.exception.EntityNotFoundException;
import com.icinemas.model.Movie;
import com.icinemas.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieDTO createMovie(MovieDTO dto) {
        Movie movie = MovieDTO.getMovieEntity(dto);
        movieRepository.save(movie);
        return Movie.getMovieDTO(movie);
    }

    public Movie getMovieById(String id) {
        return movieRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Movie not found"));
    }
}
