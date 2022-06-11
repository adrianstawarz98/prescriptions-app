package com.thesis.prescriptionsapp.repositories;

import com.thesis.prescriptionsapp.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long>
{

}
