package com.thesis.prescriptionsapp.repositories;

import com.thesis.prescriptionsapp.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long>
{

}
