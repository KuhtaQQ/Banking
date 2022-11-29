package com.andersenlab.rmtbanking.apigateway.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cors")
@Data
public class CorsProperties {
    String mappingPath;
    String[] allowedOrigins;
    String[] allowedMethods;
}

