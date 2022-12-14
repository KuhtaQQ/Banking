package com.andersenlab.rmtbanking.apigateway.configuration;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class SpringCloudConfig {

    final RouteProperties routeProperties;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(routeProperties.getUser().getId(),
                        (r -> r.path(routeProperties.getUser().getPath())
                        .uri(routeProperties.getUser().getUri())))
                .route(routeProperties.getDeposit().getId(),
                        (r -> r.path(routeProperties.getDeposit().getPath())
                        .uri(routeProperties.getDeposit().getUri())))
                .route(routeProperties.getCredit().getId(),
                        (r -> r.path(routeProperties.getCredit().getPath())
                        .uri(routeProperties.getCredit().getUri())))
                .route(routeProperties.getInfo().getId(),
                        (r -> r.path(routeProperties.getInfo().getPath())
                        .uri(routeProperties.getInfo().getUri())))
                .build();
    }
}
