package es.vicfuen.apigateway.url_shortener_gateway_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Set;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.filter.RetryFilterFunctions.retry;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
public class GatewayConfig {


    @Bean
    public RouterFunction<ServerResponse> shorteningRoute() {
        return route("url-shortening-service")
                .filter(lb("url-shortening-service"))
                .POST("/url/**", http())
//                .route(path("/url/**"), http())
//                .route(method(HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE), http())
//                .before(uri("http://localhost:9090"))
                .build()
                .and(
                    route("url-redirect-service")
                            .filter(lb("url-redirect-service"))
                            .GET("/url/**", http())
//                .route(path("/url/**"), http())
//                .route(method(HttpMethod.GET), http())
//                .before(uri("http://localhost:9091"))
                            .filter(retry(config ->
                                            config.setRetries(3)
                                                    .setSeries(Set.of(HttpStatus.Series.SERVER_ERROR))
                                                    .setMethods(Set.of(HttpMethod.GET))
                                    )
                            )
                            .build()
                );
    }


}
