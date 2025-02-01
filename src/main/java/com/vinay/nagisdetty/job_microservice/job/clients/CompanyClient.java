package com.vinay.nagisdetty.job_microservice.job.clients;

import com.vinay.nagisdetty.job_microservice.job.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-MICROSERVICE")
public interface CompanyClient {

    @GetMapping("/companies/{companyId}")
    Company getCompanyById(@PathVariable Long companyId);
}
