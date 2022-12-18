package com.andersenlab.rmtbanking.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRotesConf {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("deposit",
                        predicate -> predicate
                                .path("/auth/cards-products/**",
                                        "/auth/deposit-cards/**",
                                        "/auth/deposits/**",
                                        "/auth/deposit-products/**",
                                        "/auth/accounts/**")
                                .uri("http://10.10.14.53:9003"))
                .route("credit",
                        predicate -> predicate
                                .path("/credit-cards/**",
                                        "/credits/**",
                                        "/credit-orders/**",
                                        "/credit-products/**")
                                .uri("http://10.10.14.53:9002"))
                .route("user",
                        predicate -> predicate
                                .path("/auth/**",
                                        "/user-service/**",
                                        "/security/session/**",
                                        "/register/**",
                                        "/settings/**")
                                .uri("http://10.10.14.53:9001"))
                .route("info",
                        predicate -> predicate
                                .path("/bank-branch/**",
                                        "/currency/**",
                                        "/exchange-rates/**")
                                .uri("http://10.10.14.53:9006"))
                .build();
    }

}
