package com.icinemas.movie.service;

import com.icinemas.dto.MovieDTO;
import com.icinemas.exception.EntityNotFoundException;
import com.icinemas.movie.repository.MovieSolrRepository;
import com.icinemas.movie.solr.SolrMovie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolrService {

    private final MovieSolrRepository movieSolrRepository;

    public SolrService(MovieSolrRepository movieSolrRepository) {
        this.movieSolrRepository = movieSolrRepository;
    }

    public List<MovieDTO> searchMovieByTitle(String title) {
        List<SolrMovie> movies =  movieSolrRepository.findByTitleContains(title);
        if(movies ==null || movies.isEmpty()){
            throw new EntityNotFoundException(String.format("No movies matching the title %s found", title));
        }
        return movies.stream().map(SolrMovie::getMovieDTO).collect(Collectors.toList());
    }

}
