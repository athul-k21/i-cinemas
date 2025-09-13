package com.icinemas.movie.repository;

import com.icinemas.model.Movie;
import com.icinemas.movie.solr.SolrMovie;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface MovieSolrRepository extends SolrCrudRepository<SolrMovie, String> {
    List<SolrMovie> findByTitleContains(String title);
}
