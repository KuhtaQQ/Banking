package com.andersenlab.rmtbanking.apigateway.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class RouteConfig {
    private String id;
    private String uri;
    private String path;
}
