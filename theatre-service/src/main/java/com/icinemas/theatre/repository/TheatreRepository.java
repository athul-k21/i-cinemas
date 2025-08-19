package com.icinemas.theatre.repository;

import com.icinemas.model.Theatre;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends ReactiveMongoRepository<Theatre, String> {
}
