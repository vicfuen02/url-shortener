package es.vicfuen.url_shortening_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class UrlShorteningServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlShorteningServiceApplication.class, args);
        log.info("url-shortening-service STARTED");
    }

}
