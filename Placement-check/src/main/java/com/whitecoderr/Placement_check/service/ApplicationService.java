package com.whitecoderr.Placement_check.service;

import com.whitecoderr.Placement_check.model.Application;
import com.whitecoderr.Placement_check.repository.ApplicationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository repo;
    public ApplicationService(ApplicationRepository repo) {
        this.repo = repo;
    }
    public List<Application> saveAllApplication(List<Application> application){
        return repo.saveAll(application);
    }
    public List<Application> getAllApplication(){
        return repo.findAll();
    }
}
