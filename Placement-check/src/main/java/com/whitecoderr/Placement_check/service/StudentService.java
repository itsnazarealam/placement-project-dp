package com.whitecoderr.Placement_check.service;

import com.whitecoderr.Placement_check.model.Student;
import com.whitecoderr.Placement_check.repository.StudentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public Student saveStudent(Student student) {
        if (student.getPassword() != null && !student.getPassword().isBlank()) {
            student.setPassword(passwordEncoder.encode(student.getPassword()));
        }
        return repo.save(student);
    }

    /** Bulk import (e.g. Excel upload) — rows usually won't include a password,
     *  but hash it if one is present so nothing ever gets stored in plain text. */
    public List<Student> saveAllStudents(List<Student> students) {
        students.forEach(s -> {
            if (s.getPassword() != null && !s.getPassword().isBlank()) {
                s.setPassword(passwordEncoder.encode(s.getPassword()));
            }
        });
        return repo.saveAll(students);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public void deleteStudent(String enrollNo) {
        if (!repo.existsById(enrollNo)) {
            throw new RuntimeException("Student not found");
        }
        repo.deleteById(enrollNo);
    }

    public Student updateStudent(Student student, String enrollNo) {
        Student existing = repo.findById(enrollNo)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (student.getStudentName() != null) existing.setStudentName(student.getStudentName());
        if (student.getEmail() != null) existing.setEmail(student.getEmail());
        if (student.getMobile() != null) existing.setMobile(student.getMobile());
        if (student.getGender() != null) existing.setGender(student.getGender());
        if (student.getDob() != null) existing.setDob(student.getDob());
        if (student.getCgpa_10() != null) existing.setCgpa_10(student.getCgpa_10());
        if (student.getCgpa_12() != null) existing.setCgpa_12(student.getCgpa_12());
        if (student.getMarks_ug() != null) existing.setMarks_ug(student.getMarks_ug());
        if (student.getMarks_pg() != null) existing.setMarks_pg(student.getMarks_pg());
        if (student.getBacklogNo() != null) existing.setBacklogNo(student.getBacklogNo());
        if (student.getBacklogYear() != null) existing.setBacklogYear(student.getBacklogYear());
        if (student.getGraduationDegree() != null) existing.setGraduationDegree(student.getGraduationDegree());
        if (student.getGraduationBranch() != null) existing.setGraduationBranch(student.getGraduationBranch());
        if (student.getSkills() != null) existing.setSkills(student.getSkills());
        if (student.getResumeUrl() != null) existing.setResumeUrl(student.getResumeUrl());

        // Only touch the password if the caller actually sent a new one —
        // never overwrite an existing hash with null/blank by accident.
        if (student.getPassword() != null && !student.getPassword().isBlank()) {
            existing.setPassword(passwordEncoder.encode(student.getPassword()));
        }

        return repo.save(existing);
    }

    /** Returns the student if email+rawPassword match, otherwise null. */
    public Student authenticate(String email, String rawPassword) {
        Student student = repo.findByEmailIgnoreCase(email);
        if (student == null || student.getPassword() == null) return null;
//        boolean matches = passwordEncoder.matches(rawPassword, student.getPassword());
        boolean matches = rawPassword.equals(student.getPassword());
        return matches ? student : null;
    }
}