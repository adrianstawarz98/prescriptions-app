package com.thesis.prescriptionsapp.repositories;

import com.thesis.prescriptionsapp.domain.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Long>
{

}
