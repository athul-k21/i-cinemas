package com.icinemas.theatre.handler;

import com.icinemas.model.Theatre;
import com.icinemas.theatre.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TheatreHandler {

    @Autowired
    private TheatreService theatreService;

    public Mono<ServerResponse> getTheatre(ServerRequest request) {
        String id = request.pathVariable("id");

        return theatreService.getTheatreById(id)
                .flatMap(theatre -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(theatre));

    }

    public Mono<ServerResponse> createTheatre(ServerRequest request) {
        return request.bodyToMono(Theatre.class)
                .flatMap(theatreService::createTheatre)
                .flatMap(theatre -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON).bodyValue(theatre));

    }
}
