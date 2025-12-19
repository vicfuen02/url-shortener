package es.vicfuen.url_shortening_service.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("url_shortener")
public class UrlShortenerEntity {

    @PrimaryKey
    private String shortUrl;
    private String url;
    private LocalDateTime createdAt;

}
