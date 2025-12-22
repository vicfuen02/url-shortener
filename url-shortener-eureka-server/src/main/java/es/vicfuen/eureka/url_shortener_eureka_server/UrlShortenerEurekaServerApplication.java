package es.vicfuen.eureka.url_shortener_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class UrlShortenerEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerEurekaServerApplication.class, args);
	}

}
