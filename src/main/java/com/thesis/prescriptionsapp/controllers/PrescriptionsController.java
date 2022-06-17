package com.thesis.prescriptionsapp.controllers;

import com.thesis.prescriptionsapp.api.PrescriptionsApi;
import com.thesis.prescriptionsapp.domain.PrescriptionEntity;
import com.thesis.prescriptionsapp.mapper.PrescriptionMapper;
import com.thesis.prescriptionsapp.models.Prescription;
import com.thesis.prescriptionsapp.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PrescriptionsController implements PrescriptionsApi
{
    @Autowired
    PrescriptionService prescriptionService;

    @Override
    public ResponseEntity<Void> createPrescription(@Validated Prescription prescription)
    {
        PrescriptionEntity savedPrescription = prescriptionService.addPrescription(PrescriptionMapper.INSTANCE.mapToEntity(prescription));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPrescription.getPrescriptionId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Prescription> showPrescriptionById(Integer prescriptionId)
    {
        PrescriptionEntity prescriptionEntity = prescriptionService.getPrescriptionById(prescriptionId);
        Prescription prescription = PrescriptionMapper.INSTANCE.mapToDto(prescriptionEntity);
        return ResponseEntity.accepted().body(prescription);
    }

    @Override
    public ResponseEntity<List<Prescription>> getAllPrescriptions()
    {
        return ResponseEntity.ok()
                .body(PrescriptionMapper.INSTANCE.mapToDtoList(prescriptionService.getAllPrescriptions()));
    }
}
