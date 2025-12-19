package es.vicfuen.url_redirect_service.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.vicfuen.url_redirect_service.controller.dto.UrlReqDto;
import es.vicfuen.url_redirect_service.service.redirect.UrlRedirectService;
import es.vicfuen.url_redirect_service.controller.mapper.UrlRedirectMapper;

@Slf4j
@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlRedirectRestController {

    private final UrlRedirectService urlRedirectService;
    private final UrlRedirectMapper urlRedirectMapper;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> getLongUrl(@PathVariable String shortUrl) {
        log.info("Redirecting short URL: {}", shortUrl);
        return urlRedirectService.getLongUrl(shortUrl)
                .map(urlModel -> ResponseEntity.status(HttpStatus.FOUND)
                        .location(URI.create(urlModel.getUrl()))
                        .build()
                )
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<UrlReqDto> getUrls() {
        return urlRedirectMapper.toDtoList(
                urlRedirectService.getUrls());
    }

}
