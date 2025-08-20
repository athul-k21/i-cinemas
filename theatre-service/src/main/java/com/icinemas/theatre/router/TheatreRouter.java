package com.icinemas.theatre.router;


import com.icinemas.theatre.handler.TheatreHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class TheatreRouter {

    @Autowired
    private TheatreHandler theatreHandler;

    @Bean
    public RouterFunction<?> getTheatre() {
        return RouterFunctions.route(RequestPredicates.GET("/api/v1/theatre/{id}"),
                theatreHandler::getTheatre)
                .andRoute(RequestPredicates.POST("api/v1/theatre")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        theatreHandler::createTheatre);
    }
}
