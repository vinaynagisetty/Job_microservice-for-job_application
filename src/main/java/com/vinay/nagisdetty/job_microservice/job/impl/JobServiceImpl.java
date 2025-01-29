package com.vinay.nagisdetty.job_microservice.job.impl;



import com.vinay.nagisdetty.job_microservice.job.Job;
import com.vinay.nagisdetty.job_microservice.job.JobRepository;
import com.vinay.nagisdetty.job_microservice.job.JobService;
import com.vinay.nagisdetty.job_microservice.job.dto.JobsWitCompanyDto;
import com.vinay.nagisdetty.job_microservice.job.external.Company;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    // private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobsWitCompanyDto> findAll() {
       List<Job> jobs =  jobRepository.findAll();
       List<JobsWitCompanyDto> jobsWitCompanyDtos = new ArrayList<>();

       for(Job job:jobs) {
              JobsWitCompanyDto jobsWitCompanyDto = new JobsWitCompanyDto();
              jobsWitCompanyDto.setJob(job);
           RestTemplate restTemplate=new RestTemplate();
           Company company= restTemplate.getForObject("http://localhost:8081/companies/"+job.getCompanyId(),Company.class);
              jobsWitCompanyDto.setCompany(company);
              jobsWitCompanyDtos.add(jobsWitCompanyDto);

       }

       return jobsWitCompanyDtos;


    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}