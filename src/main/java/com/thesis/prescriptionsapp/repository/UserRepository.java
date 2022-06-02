package com.thesis.prescriptionsapp.repository;

import com.thesis.prescriptionsapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
