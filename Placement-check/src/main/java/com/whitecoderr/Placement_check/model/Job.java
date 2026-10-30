package com.whitecoderr.Placement_check.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue()
    private String jobId;
    private String companyId;
    private String jobRole;
    private String jobDesc;
    private Long lpaPackage;
    private Double minCgpa;
    private String allowedBranches;
    private String requiredSkills;
    private Integer maxBacklogs;
    private String interviewDate;
    private String resultDate;
    private Integer vacancy;

    public Long getLpaPackage() {
        return lpaPackage;
    }

    public void setLpaPackage(Long lpaPackage) {
        this.lpaPackage = lpaPackage;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public Double getMinCgpa() {
        return minCgpa;
    }

    public void setMinCgpa(Double minCgpa) {
        this.minCgpa = minCgpa;
    }

    public String getAllowedBranches() {
        return allowedBranches;
    }

    public void setAllowedBranches(String allowedBranches) {
        this.allowedBranches = allowedBranches;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public Integer getMaxBacklogs() {
        return maxBacklogs;
    }

    public void setMaxBacklogs(Integer maxBacklogs) {
        this.maxBacklogs = maxBacklogs;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {
        this.resultDate = resultDate;
    }

    public Integer getVacancy() {
        return vacancy;
    }

    public void setVacancy(Integer vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId='" + jobId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", jobRole='" + jobRole + '\'' +
                ", jobDesc='" + jobDesc + '\'' +
                ", lpaPackage=" + lpaPackage +
                ", minCgpa=" + minCgpa +
                ", allowedBranches='" + allowedBranches + '\'' +
                ", requiredSkills='" + requiredSkills + '\'' +
                ", maxBacklogs=" + maxBacklogs +
                ", interviewDate='" + interviewDate + '\'' +
                ", resultDate='" + resultDate + '\'' +
                ", vacancy=" + vacancy +
                '}';
    }
}
