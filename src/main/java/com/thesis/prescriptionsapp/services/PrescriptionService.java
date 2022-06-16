package com.thesis.prescriptionsapp.services;

import com.thesis.prescriptionsapp.domain.Prescription;
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

    public List<Prescription> getAllPrescriptions()
    {
        return prescriptionRepository.findAll();
    }

    public Prescription addPrescription(final Prescription prescription)
    {
        return prescriptionRepository.save(prescription);
    }
}
