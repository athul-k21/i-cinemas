package com.icinemas.movie.solr;

import com.icinemas.dto.MovieDTO;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;
import java.util.Date;

@SolrDocument(collection = "movie")
@Data
public class SolrMovie {
    @Id
    private String id;

    @Field
    private String title;

    @Field
    private String language;

    @Field()
    private String genre;

    @Field
    private Date releaseDate;

    public static MovieDTO getMovieDTO(SolrMovie solrMovie) {
        return MovieDTO.builder().id(solrMovie.getId()).title(solrMovie.getTitle()).build();
    }
}
