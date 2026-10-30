package com.whitecoderr.Placement_check.controller;

import com.whitecoderr.Placement_check.model.Company;
import com.whitecoderr.Placement_check.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "http://localhost:5173")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    // ── GET /api/companies
    // Returns only approved companies → used by public Companies.jsx page
    @GetMapping
    public List<Company> getApprovedCompanies() {
        return service.getApprovedCompanies();
    }

    // ── GET /api/companies/all
    // Returns all companies → used by Admin panel
    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return service.getAllCompanies();
    }

    // ── GET /api/companies/by-name?name=TechCorp
    // Returns jobs for one company → used by CompanyDashboard.jsx
    @GetMapping("/by-name")
    public List<Company> getByName(@RequestParam String name) {
        return service.getCompaniesByName(name);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return service.saveCompany(company);
    }

    // ── PATCH /api/companies/{id}/approve
    // Admin approves a posting → used by AdminApprovals.jsx
    @PatchMapping("/{id}/approve")
    public Company approveCompany(@PathVariable Long id) {
        return service.approveCompany(id);
    }

    // ── DELETE /api/companies/{id}
    // Admin deletes a posting
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        service.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
        return service.updateCompany(id, company);
    }
}