package com.whitecoderr.Placement_check.repository;

import com.whitecoderr.Placement_check.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
