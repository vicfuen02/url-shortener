package es.vicfuen.url_shortening_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.vicfuen.url_shortening_service.controller.dto.UrlShortenerReqDto;
import es.vicfuen.url_shortening_service.controller.dto.UrlShortenerResDto;
import es.vicfuen.url_shortening_service.controller.mapper.UrlShortenerMapper;
import es.vicfuen.url_shortening_service.service.shortener.UrlShortenerService;

@Slf4j
@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlShortenerRestController {

    private final UrlShortenerService urlShortenerService;
    private final UrlShortenerMapper urlShortenerMapper;

    @PostMapping("/shorten")
    public UrlShortenerResDto urlShortener(@RequestBody UrlShortenerReqDto url) {
        return urlShortenerMapper.toResDto(
            urlShortenerService.urlShortener(
                urlShortenerMapper.toModel(url)
            )
        );
    }

}
