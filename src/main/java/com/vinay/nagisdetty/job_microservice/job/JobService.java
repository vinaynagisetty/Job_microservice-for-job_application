package com.vinay.nagisdetty.job_microservice.job;

import com.vinay.nagisdetty.job_microservice.job.dto.JobsWitCompanyDto;

import java.util.List;

public interface JobService {
    List<JobsWitCompanyDto> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
