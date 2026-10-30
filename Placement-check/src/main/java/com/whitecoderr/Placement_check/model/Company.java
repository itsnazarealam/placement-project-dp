package com.whitecoderr.Placement_check.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;          // Fixed: Long to match JpaRepository<Company, Long>

    private String companyName;
    private String companyMail;

    private String role;
    private String packageOffered;
    private Double minCgpa;
    private String branches;
    private String requiredSkills;
    private String lastDate;
    private String jobDesc;

    private boolean approved;


    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getCompanyMail() { return companyMail; }
    public void setCompanyMail(String companyMail) { this.companyMail = companyMail; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPackageOffered() { return packageOffered; }
    public void setPackageOffered(String packageOffered) { this.packageOffered = packageOffered; }

    public Double getMinCgpa() { return minCgpa; }
    public void setMinCgpa(Double minCgpa) { this.minCgpa = minCgpa; }

    public String getBranches() { return branches; }
    public void setBranches(String branches) { this.branches = branches; }

    public String getRequiredSkills() { return requiredSkills; }
    public void setRequiredSkills(String requiredSkills) { this.requiredSkills = requiredSkills; }

    public String getLastDate() { return lastDate; }
    public void setLastDate(String lastDate) { this.lastDate = lastDate; }

    public String getJobDesc() { return jobDesc; }
    public void setJobDesc(String jobDesc) { this.jobDesc = jobDesc; }

    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyMail='" + companyMail + '\'' +
                ", role='" + role + '\'' +
                ", packageOffered='" + packageOffered + '\'' +
                ", minCgpa=" + minCgpa +
                ", branches='" + branches + '\'' +
                ", requiredSkills='" + requiredSkills + '\'' +
                ", lastDate='" + lastDate + '\'' +
                ", approved=" + approved +
                '}';
    }
}