package com.vinay.nagisdetty.job_microservice.job.mapper;

import com.vinay.nagisdetty.job_microservice.job.Job;
import com.vinay.nagisdetty.job_microservice.job.dto.JObDto;
import com.vinay.nagisdetty.job_microservice.job.external.Company;
import com.vinay.nagisdetty.job_microservice.job.external.Review;

import java.util.List;

public class MapJobWithCompsnyDto {
    public static JObDto mapJobWithCompanyDto(Job job, Company company, List<Review> reviews) {
        JObDto JObDto = new JObDto();
        JObDto.setId(job.getId());
        JObDto.setTitle(job.getTitle());
        JObDto.setDescription(job.getDescription());
        JObDto.setMinSalary(job.getMinSalary());
        JObDto.setMaxSalary(job.getMaxSalary());
        JObDto.setLocation(job.getLocation());
        JObDto.setCompany(company);
        JObDto.setReviews(reviews);

        return JObDto;
    }
}
