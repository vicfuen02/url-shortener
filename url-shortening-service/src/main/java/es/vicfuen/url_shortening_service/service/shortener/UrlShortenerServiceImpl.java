package es.vicfuen.url_shortening_service.service.shortener;

import es.vicfuen.ccassandraCommon.mapper.UrlModelEntityMapper;
import es.vicfuen.ccassandraCommon.model.UrlModel;
import es.vicfuen.url_shortening_service.repository.UrlShorteningRepository;
import es.vicfuen.url_shortening_service.service.urlHashing.UrlHashingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final UrlHashingService urlHashingService;
    private final UrlShorteningRepository urlShorteningRepository;
    private final UrlModelEntityMapper urlShortenerEntityMapper;

    @Override
    @Transactional
    public UrlModel urlShortener(UrlModel urlShortener) {

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
