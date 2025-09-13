package com.icinemas.model;

import com.icinemas.dto.MovieDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "MOVIES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String genre;

    private String certificate;
    private Integer durationMin;
    private Date releaseDate;
    private String director;

    @Lob
    private String castNames;

    @Lob
    private String synopsis;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static MovieDTO getMovieDTO(Movie movie){
        return MovieDTO.builder().id(movie.getId()).title(movie.getTitle()).language(movie.getLanguage())
                .genre(movie.getGenre())
                .certificate(movie.getCertificate())
                .durationMin(movie.getDurationMin())
                .releaseDate(movie.getReleaseDate())
                .director(movie.getDirector())
                .castNames(movie.getCastNames())
                .synopsis(movie.getSynopsis())
                .createdAt(movie.getCreatedAt())
                .updatedAt(movie.getUpdatedAt())
                .build();
    }
}

