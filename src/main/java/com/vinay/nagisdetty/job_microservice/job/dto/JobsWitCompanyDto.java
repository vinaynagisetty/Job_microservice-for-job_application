package com.vinay.nagisdetty.job_microservice.job.dto;

import com.vinay.nagisdetty.job_microservice.job.Job;
import com.vinay.nagisdetty.job_microservice.job.external.Company;

public class JobsWitCompanyDto {

    private Job job;

    private Company company;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
