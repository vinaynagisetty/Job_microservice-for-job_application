package com.vinay.nagisdetty.job_microservice.job;

import com.vinay.nagisdetty.job_microservice.job.dto.JObDto;

import java.util.List;

public interface JobService {
    List<JObDto> findAll();
    void createJob(Job job);

    JObDto getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
