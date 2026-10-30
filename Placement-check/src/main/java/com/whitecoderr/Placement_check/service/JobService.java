package com.whitecoderr.Placement_check.service;

import com.whitecoderr.Placement_check.model.Job;
import com.whitecoderr.Placement_check.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository repo;
    public JobService(JobRepository repo) {
        this.repo = repo;
    }

    public List<Job> getAllJobs() {
        return repo.findAll();
    }
    public Job saveJob(Job job){
        return repo.save(job);
    }

    public Job updateJob(Job job, Long jobId) {
//        if(!repo.existsById(job.getJobId())){
//            throw new RuntimeException("job not found");
//        }
//        return repo.save(job);

        Optional<Job> patchData = repo.findById(jobId);
        if(patchData.isPresent()){
            Job patchTemp = patchData.orElseThrow();
            patchTemp.setJobDesc(job.getJobDesc()!=null?job.getJobDesc():patchTemp.getJobDesc());
            patchTemp.setLpaPackage(job.getLpaPackage()!=null?job.getLpaPackage():patchTemp.getLpaPackage());
            patchTemp.setMinCgpa(job.getMinCgpa()!=null?job.getMinCgpa():patchTemp.getMinCgpa());
            patchTemp.setAllowedBranches(job.getAllowedBranches()!=null?job.getAllowedBranches():patchTemp.getAllowedBranches());
            patchTemp.setRequiredSkills(job.getRequiredSkills()!=null?job.getRequiredSkills():patchTemp.getRequiredSkills());
            patchTemp.setInterviewDate(job.getInterviewDate()!=null?job.getInterviewDate():patchTemp.getInterviewDate());

            return repo.save(patchTemp);
        }
        else {
            System.out.println("Record not found");
        }
        return null;
    }

    public Job deleteJob(Long jobId){
        if(!repo.existsById(jobId)){
            System.out.println("Job is not found");
            throw new RuntimeException("Job is not found");
        }
        else{
            repo.deleteById(jobId);
            System.out.println("Deleted");
        }
        return null;
    }
}
