package com.thesis.prescriptionsapp.repository;

import com.thesis.prescriptionsapp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String username);
}