package com.services.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/dice/**")
                        .uri("lb://EUREKA-DICE-THROWER"))
                .route(r -> r.path("/user")
                        .uri("lb://EUREKA-USER-DATABASE"))
                .build();
    }

}