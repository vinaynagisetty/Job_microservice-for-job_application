package com.vinay.nagisdetty.job_microservice.job;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
