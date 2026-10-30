package com.whitecoderr.Placement_check.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private String enrollNo;
    private String studentName;
    private String email;   //college id only
    private Long mobile;
    private String gender;
    private String dob;
    private Double cgpa_10;
    private Double cgpa_12;
    private Double marks_ug;
    private Double marks_pg;
    private Integer backlogNo;
    private String backlogYear;
    private String graduationDegree;
    private String graduationBranch;
    private String skills;
    private String resumeUrl;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnrollNo() {
        return enrollNo;
    }

    public void setEnrollNo(String enrollNo) {
        this.enrollNo = enrollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Double getCgpa_10() {
        return cgpa_10;
    }

    public void setCgpa_10(Double cgpa_10) {
        this.cgpa_10 = cgpa_10;
    }

    public Double getCgpa_12() {
        return cgpa_12;
    }

    public void setCgpa_12(Double cgpa_12) {
        this.cgpa_12 = cgpa_12;
    }

    public Double getMarks_ug() {
        return marks_ug;
    }

    public void setMarks_ug(Double marks_ug) {
        this.marks_ug = marks_ug;
    }

    public Double getMarks_pg() {
        return marks_pg;
    }

    public void setMarks_pg(Double marks_pg) {
        this.marks_pg = marks_pg;
    }

    public Integer getBacklogNo() {
        return backlogNo;
    }

    public void setBacklogNo(Integer backlogNo) {
        this.backlogNo = backlogNo;
    }

    public String getBacklogYear() {
        return backlogYear;
    }

    public void setBacklogYear(String backlogYear) {
        this.backlogYear = backlogYear;
    }

    public String getGraduationDegree() {
        return graduationDegree;
    }

    public void setGraduationDegree(String graduationDegree) {
        this.graduationDegree = graduationDegree;
    }

    public String getGraduationBranch() {
        return graduationBranch;
    }

    public void setGraduationBranch(String graduationBranch) {
        this.graduationBranch = graduationBranch;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    @Override
    public String toString() {
        return "Student{" +
                "enrollNo='" + enrollNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", cgpa_10=" + cgpa_10 +
                ", cgpa_12=" + cgpa_12 +
                ", marks_ug=" + marks_ug +
                ", marks_pg=" + marks_pg +
                ", backlogNo=" + backlogNo +
                ", backlogYear='" + backlogYear + '\'' +
                ", graduationDegree='" + graduationDegree + '\'' +
                ", graduationBranch='" + graduationBranch + '\'' +
                ", skills='" + skills + '\'' +
                ", resumeUrl='" + resumeUrl + '\'' +
                ", password='[PROTECTED]'" +
                '}';
    }
}
