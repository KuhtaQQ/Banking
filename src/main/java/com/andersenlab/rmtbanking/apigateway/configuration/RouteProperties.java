package com.andersenlab.rmtbanking.apigateway.configuration;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "routes")
@Data
@NoArgsConstructor
public class RouteProperties {
    private RouteConfig user;
    private RouteConfig credit;
    private RouteConfig deposit;
    private RouteConfig info;
}