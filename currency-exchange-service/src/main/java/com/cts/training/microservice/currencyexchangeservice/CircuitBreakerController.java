package com.cts.training.microservice.currencyexchangeservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.*;

@RestController
public class CircuitBreakerController {
	
	@GetMapping("/sample-api")
	public String sampleApi() {
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",String.class); 
		return forEntity.getBody();
	}

}
