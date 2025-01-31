package com.vinay.nagisdetty.job_microservice.job.impl;



import com.vinay.nagisdetty.job_microservice.job.Job;
import com.vinay.nagisdetty.job_microservice.job.JobRepository;
import com.vinay.nagisdetty.job_microservice.job.JobService;
import com.vinay.nagisdetty.job_microservice.job.dto.JobsWitCompanyDto;
import com.vinay.nagisdetty.job_microservice.job.external.Company;
import com.vinay.nagisdetty.job_microservice.job.mapper.MapJobWithCompsnyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    // private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }




    @Override
    public List<JobsWitCompanyDto> findAll() {
       List<Job> jobs =  jobRepository.findAll();
       List<JobsWitCompanyDto> jobsWitCompanyDtos = new ArrayList<>();



       return jobs.stream().map(job -> mapJobToDto(job)).collect(Collectors.toList());


    }
    private JobsWitCompanyDto mapJobToDto(Job job) {


            // Fetch the company details for the given job
//         RestTemplate restTemplate = new RestTemplate();
            Company company = restTemplate.getForObject("http://COMPANY-MICROSERVICE/companies/" + job.getCompanyId(), Company.class);
//

        JobsWitCompanyDto jobsWitCompanyDto = MapJobWithCompsnyDto.mapJobWithCompanyDto(job, company);
        jobsWitCompanyDto.setCompany(company);


        return jobsWitCompanyDto;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobsWitCompanyDto getJobById(Long id) {
      Job job= jobRepository.findById(id).orElse(null);

        return mapJobToDto(job);

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