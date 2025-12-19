package es.vicfuen.url_shortening_service.service.shortener;

import org.springframework.stereotype.Service;

import es.vicfuen.url_shortening_service.service.model.UrlShortener;
import es.vicfuen.url_shortening_service.service.urlHashing.UrlHashingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final UrlHashingService urlHashingService;


    @Override
    public UrlShortener urlShortener(UrlShortener urlShortener) {

        log.info("Shortening url: {}", urlShortener.getUrl());
        String urlHashed = urlHashingService.urlHashing(urlShortener.getUrl());
        urlShortener.setShortUrl(urlHashed);
        
        log.info("Shortened url: {}", urlShortener.getShortUrl());
        return urlShortener;
    }

}
