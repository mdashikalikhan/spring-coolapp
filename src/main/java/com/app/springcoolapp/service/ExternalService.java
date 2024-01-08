package com.app.springcoolapp.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {
    private final RestTemplate restTemplate;

    @Value("${external.URL1}")
    private String externalURL;

    public ExternalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "externalService", fallbackMethod = "fallback")
    public String callResilenceService(){
        return restTemplate.getForObject(externalURL,String.class);
    }

    public String fallback(Throwable t){
        return "Fallback response: " + t.getMessage();
    }
}
