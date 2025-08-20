package com.icinemas.theatre.service;

import com.icinemas.model.Theatre;
import com.icinemas.theatre.exception.InvalidFieldException;
import com.icinemas.theatre.exception.NotFoundException;
import com.icinemas.theatre.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Flux<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Mono<Theatre> getTheatreById(final String id) {
        return theatreRepository.findById(id).
                map(data -> data)
                .switchIfEmpty(Mono.defer(() ->
                        Mono.error(new NotFoundException("Theatre not found"))));
    }
    public Mono<Theatre> createTheatre(final Theatre theatre) {
        return validateTheatre(theatre)
                .flatMap(theatreRepository::insert);
    }

    private Mono<Theatre> validateTheatre(final Theatre theatre) {
        if(theatre.getName() == null) {
            throw new InvalidFieldException("Theatre name is mandatory");
        }
        else if(theatre.getCity() == null) {
            throw new InvalidFieldException("Theatre city is mandatory");
        }
        else if(theatre.getAddress() == null) {
            throw new InvalidFieldException("Theatre address is mandatory");
        }
        return Mono.just(theatre);
    }
}
