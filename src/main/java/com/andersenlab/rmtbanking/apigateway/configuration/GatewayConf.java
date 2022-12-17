package com.andersenlab.rmtbanking.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConf {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(predicate -> predicate
                         .path("/auth/deposit-products/**", "/auth/cards-products/")
                         .uri("http://10.10.14.11:9003"))
                .route(predicate -> predicate
                        .path("/exchange-rates")
                        .uri("http://10.10.14.53:9006"))
                .route(predicate -> predicate
                        .path("/currency")
                        .uri("http://10.10.14.53:9006"))
                .route(predicate -> predicate
                        .path("/credit-products")
                        .uri("http://10.10.14.11:9002"))
                .build();

    }
}
