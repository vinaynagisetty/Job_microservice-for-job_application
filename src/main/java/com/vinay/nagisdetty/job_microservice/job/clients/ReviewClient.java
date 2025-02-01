package com.vinay.nagisdetty.job_microservice.job.clients;

import com.vinay.nagisdetty.job_microservice.job.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEW-MICROSERVICE")
public interface ReviewClient {
    @GetMapping("/reviews")
    List<Review> getReviewsByCompanyId(@RequestParam("companyId") Long companyId);

}
