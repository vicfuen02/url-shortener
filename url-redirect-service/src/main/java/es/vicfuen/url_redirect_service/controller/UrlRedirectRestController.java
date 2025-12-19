package es.vicfuen.url_redirect_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/url")
public class UrlRedirectRestController {

    @GetMapping("/{shortUrl}")
    public void urlShortener(@PathVariable String shortUrl) {
        log.info("Short UR ({}): ", shortUrl);
    }

}
