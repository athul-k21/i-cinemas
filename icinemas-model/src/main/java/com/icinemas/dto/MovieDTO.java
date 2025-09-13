package com.icinemas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.icinemas.model.Movie;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private String id;
    @NotBlank(message = "Movie title is mandatory")
    private String title;
    @NotBlank(message = "Movie language is mandatory")
    private String language;
    @NotBlank(message = "Movie genre is mandatory")
    private String genre;
    private String certificate;
    private Integer durationMin;
    private Date releaseDate;
    private String director;
    private String castNames;
    private String synopsis;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Movie getMovieEntity(MovieDTO dto){
        return Movie.builder().id(UUID.randomUUID().toString()).title(dto.getTitle()).language(dto.getLanguage())
                .genre(dto.getGenre())
                .certificate(dto.getCertificate())
                .durationMin(dto.getDurationMin())
                .releaseDate(dto.getReleaseDate())
                .director(dto.getDirector())
                .castNames(dto.getCastNames())
                .synopsis(dto.getSynopsis())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
