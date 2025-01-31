package com.vinay.nagisdetty.job_microservice.job.mapper;

import com.vinay.nagisdetty.job_microservice.job.Job;
import com.vinay.nagisdetty.job_microservice.job.dto.JobsWitCompanyDto;
import com.vinay.nagisdetty.job_microservice.job.external.Company;

public class MapJobWithCompsnyDto {
    public static JobsWitCompanyDto mapJobWithCompanyDto(Job job, Company company) {
        JobsWitCompanyDto jobsWitCompanyDto = new JobsWitCompanyDto();
        jobsWitCompanyDto.setId(job.getId());
        jobsWitCompanyDto.setTitle(job.getTitle());
        jobsWitCompanyDto.setDescription(job.getDescription());
        jobsWitCompanyDto.setMinSalary(job.getMinSalary());
        jobsWitCompanyDto.setMaxSalary(job.getMaxSalary());
        jobsWitCompanyDto.setLocation(job.getLocation());
        jobsWitCompanyDto.setCompany(company);

        return jobsWitCompanyDto;
    }
}
