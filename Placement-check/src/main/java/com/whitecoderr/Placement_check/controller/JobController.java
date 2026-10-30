package com.whitecoderr.Placement_check.controller;

import com.whitecoderr.Placement_check.model.Job;
import com.whitecoderr.Placement_check.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Job")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }
    @GetMapping("/JobSelect")
    public List<Job> getAllJobs(){
        return service.getAllJobs();
    }

    @PostMapping("/JobInsert")
    public Job addAll(@RequestBody Job jobs){
        return service.saveJob(jobs);
    }


//    @PutMapping("/JobUpdate/{jobId}")
//    public Job updateJob(@PathVariable Long jobId, @RequestBody Job job){
//        System.out.println("inside");
//        job.setJobId(jobId);
//        return service.updateJob(job);
//    }

    @PatchMapping("/JobUpdate/{jobId}")
    public Job updateJob(@PathVariable Long jobId, @RequestBody Job job){
        return service.updateJob(job, jobId);
    }

    @DeleteMapping("/JobDelete/{jobId}")
    public Job deleteJob(@PathVariable Long jobId){
        return service.deleteJob(jobId);
    }
}
