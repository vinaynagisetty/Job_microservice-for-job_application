package com.vinay.nagisdetty.job_microservice.job.logging;
import io.micrometer.tracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TraceController {

    private static final Logger log = LoggerFactory.getLogger(TraceController.class);

    private final Tracer tracer;

    public TraceController(Tracer tracer) {
        this.tracer = tracer;
    }

    @GetMapping("/trace-test")
    public String traceTest() {
        log.info("Trace ID: {}", tracer.currentSpan().context().traceId());
        log.info("Span ID: {}", tracer.currentSpan().context().spanId());
        return "Tracing Test";
    }
}
