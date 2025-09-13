package com.icinemas.movie.controller;

import com.icinemas.dto.MovieDTO;
import com.icinemas.model.Movie;
import com.icinemas.movie.service.MovieService;
import com.icinemas.movie.service.SolrService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
      private final SolrService solrService;

    @PostMapping()
    public ResponseEntity<MovieDTO> createMovie(@Valid @RequestBody MovieDTO movie) {
        return ResponseEntity.ok().body(movieService.createMovie(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(movieService.getMovieById(id));
    }

    @GetMapping("/searchByTitle")
    public ResponseEntity<List<MovieDTO>> searchMovieByTitle(@RequestParam("title") String title) {
        return ResponseEntity.ok().body(solrService.searchMovieByTitle(title));
    }
}
