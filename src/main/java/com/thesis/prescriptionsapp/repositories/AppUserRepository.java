package com.thesis.prescriptionsapp.repositories;

import com.thesis.prescriptionsapp.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long>
{

}