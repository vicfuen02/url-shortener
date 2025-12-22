package es.vicfuen.url_shortening_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {
        "es.vicfuen.url_shortening_service",
        "es.vicfuen.ccassandraCommon"
})
@EnableDiscoveryClient
public class UrlShorteningServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlShorteningServiceApplication.class, args);
        log.info("""
                --------------------------------------
                --- url-shortening-service STARTED ---
                --------------------------------------
        """);
    }

}
