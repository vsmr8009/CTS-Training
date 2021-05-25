package com.cts.training.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
				.route(r -> r.path("/currency-conversion/**").uri("lb://currency-conversion-service"))
				.route(r -> r.path("/currency-converter-feign/**").uri("lb://currency-conversion-service")).build();
	}

}
