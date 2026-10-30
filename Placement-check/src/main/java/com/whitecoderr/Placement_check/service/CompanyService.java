package com.whitecoderr.Placement_check.service;

import com.whitecoderr.Placement_check.model.Company;
import com.whitecoderr.Placement_check.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository repo;

    public CompanyService(CompanyRepository repo) {
        this.repo = repo;
    }

    // ── Called by CompanyRegister form ──────────────────────────────────────
    // Sets approved=false so admin must approve before it shows publicly
    public Company saveCompany(Company company) {
        company.setApproved(false);   // always pending on first submit
        return repo.save(company);
    }

    // ── Called by public Companies page (approved only) ─────────────────────
    public List<Company> getApprovedCompanies() {
        return repo.findByApprovedTrue();
    }

    // ── Called by Admin panel (all companies) ────────────────────────────────
    public List<Company> getAllCompanies() {
        return repo.findAll();
    }

    // ── Called by Company Dashboard (jobs for this company) ──────────────────
    public List<Company> getCompaniesByName(String companyName) {
        return repo.findByCompanyNameIgnoreCase(companyName);
    }

    // ── Called by Admin approvals panel ──────────────────────────────────────
    public Company approveCompany(Long companyId) {
        Company c = repo.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found: " + companyId));
        c.setApproved(true);
        return repo.save(c);
    }

    // ── Called by Admin delete ────────────────────────────────────────────────
    public void deleteCompany(Long companyId) {
        if (!repo.existsById(companyId)) {
            throw new RuntimeException("Company not found: " + companyId);
        }
        repo.deleteById(companyId);
    }

    public Company updateCompany(Long companyId, Company updated) {
        Company existing = repo.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found: " + companyId));
        existing.setCompanyName(updated.getCompanyName());
        existing.setCompanyMail(updated.getCompanyMail());
        return repo.save(existing);
    }
}