package com.whitecoderr.Placement_check.repository;

import com.whitecoderr.Placement_check.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserMail(String userMail);
}
