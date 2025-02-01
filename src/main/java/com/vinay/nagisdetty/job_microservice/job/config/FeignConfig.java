package com.vinay.nagisdetty.job_microservice.job.config;

import feign.RequestInterceptor;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.propagation.Propagator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor tracingInterceptor(Tracer tracer, Propagator propagator) {
        return requestTemplate -> {
            var currentSpan = tracer.currentSpan();
            if (currentSpan != null) {
                propagator.inject(currentSpan.context(), requestTemplate, (req, key, value) -> req.header(key, value));
            }
        };
    }
}

