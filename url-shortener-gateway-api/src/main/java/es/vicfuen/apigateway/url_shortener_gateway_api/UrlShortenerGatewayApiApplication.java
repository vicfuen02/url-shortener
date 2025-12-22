package es.vicfuen.apigateway.url_shortener_gateway_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UrlShortenerGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerGatewayApiApplication.class, args);
	}

}
