package com.andersenlab.rmtbanking.apigateway.configuration;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.client.HttpClient;

@Configuration
public class GatewayConfig {

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("deposit", predicate -> predicate
//                        .header("router-value", "1")
//                        .and()
//                        .path("auth/deposit-products")
//                        .filters(f -> f.prefixPath())
//                        .uri("http://http://10.10.14.11:9003"));
//    }
//
////    @Bean
////    public HttpClient httpClient() {
////        return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
////    }
}
