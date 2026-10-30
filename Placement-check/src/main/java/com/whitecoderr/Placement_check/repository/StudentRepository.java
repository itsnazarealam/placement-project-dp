package com.whitecoderr.Placement_check.repository;

import com.whitecoderr.Placement_check.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Student findByEmailIgnoreCase(String email);
}
