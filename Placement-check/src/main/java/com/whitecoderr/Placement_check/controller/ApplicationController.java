package com.whitecoderr.Placement_check.controller;

import com.whitecoderr.Placement_check.model.Application;
import com.whitecoderr.Placement_check.service.ApplicationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationService service;
    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Application> getAllCompanies(){
        return service.getAllApplication();
    }

    @PostMapping("/addAll")
    public List<Application> addAll(@RequestBody List<Application> applications){
        return service.saveAllApplication(applications);
    }
}
