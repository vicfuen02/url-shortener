package es.vicfuen.url_shortening_service.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlShortener {

    private String url;
    private String shortUrl;
    private LocalDateTime createdAt;

}
