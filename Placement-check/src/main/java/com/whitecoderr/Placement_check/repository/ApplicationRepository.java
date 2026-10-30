package com.whitecoderr.Placement_check.repository;

import com.whitecoderr.Placement_check.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
