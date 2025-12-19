package es.vicfuen.url_shortening_service.service.shortener;

import es.vicfuen.url_shortening_service.repository.UrlShorteningRepository;
import es.vicfuen.url_shortening_service.repository.entity.UrlShortenerEntity;
import es.vicfuen.url_shortening_service.service.mapper.UrlShortenerEntityMapper;
import es.vicfuen.url_shortening_service.service.model.UrlShortener;
import es.vicfuen.url_shortening_service.service.urlHashing.UrlHashingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final UrlHashingService urlHashingService;
    private final UrlShorteningRepository urlShorteningRepository;
    private final UrlShortenerEntityMapper urlShortenerEntityMapper;

    @Override
    public UrlShortener urlShortener(UrlShortener urlShortener) {

        log.info("Shortening url: {}", urlShortener.getUrl());
        String urlHashed = urlHashingService.urlHashing(urlShortener.getUrl());
        urlShortener.setShortUrl(urlHashed);

        urlShorteningRepository.save(
            urlShortenerEntityMapper.toEntity(urlShortener)
        );

        log.info("Shortened url: {}", urlShortener.getShortUrl());
        return urlShortener;
    }

}
