package com.thesis.prescriptionsapp.services;

import com.thesis.prescriptionsapp.domain.PrescriptionEntity;
import com.thesis.prescriptionsapp.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService
{
    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository)
    {
        this.prescriptionRepository = prescriptionRepository;
    }

    public List<PrescriptionEntity> getAllPrescriptions()
    {
        return prescriptionRepository.findAll();
    }

    public PrescriptionEntity addPrescription(final PrescriptionEntity prescriptionEntity)
    {
        return prescriptionRepository.save(prescriptionEntity);
    }

    public PrescriptionEntity getPrescriptionById(final Integer prescriptionId)
    {
        return prescriptionRepository.getReferenceById(Long.valueOf(prescriptionId));
    }

}
