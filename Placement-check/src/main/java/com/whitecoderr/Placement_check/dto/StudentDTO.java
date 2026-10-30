package com.whitecoderr.Placement_check.dto;

import com.whitecoderr.Placement_check.model.Student;

public record StudentDTO(
        String enrollNo,
        String studentName,
        String email,
        Long mobile,
        String gender,
        String dob,
        Double cgpa_10,
        Double cgpa_12,
        Double marks_ug,
        Double marks_pg,
        Integer backlogNo,
        String backlogYear,
        String graduationDegree,
        String graduationBranch,
        String skills,
        String resumeUrl
) {

    public StudentDTO(Student s) {
        this(
                s.getEnrollNo(),
                s.getStudentName(),
                s.getEmail(),
                s.getMobile(),
                s.getGender(),
                s.getDob(),
                s.getCgpa_10(),
                s.getCgpa_12(),
                s.getMarks_ug(),
                s.getMarks_pg(),
                s.getBacklogNo(),
                s.getBacklogYear(),
                s.getGraduationDegree(),
                s.getGraduationBranch(),
                s.getSkills(),
                s.getResumeUrl()
        );
    }

}

