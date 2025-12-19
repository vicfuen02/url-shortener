package es.vicfuen.url_redirect_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class UrlRedirectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlRedirectServiceApplication.class, args);
		log.info("url-redirect-service STARTED");
	}

}
