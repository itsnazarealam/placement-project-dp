package com.whitecoderr.Placement_check.repository;

import com.whitecoderr.Placement_check.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // Find all jobs posted by a specific company name (for company dashboard)
    List<Company> findByCompanyNameIgnoreCase(String companyName);

    // Find only approved companies (for public Companies page)
    List<Company> findByApprovedTrue();
}