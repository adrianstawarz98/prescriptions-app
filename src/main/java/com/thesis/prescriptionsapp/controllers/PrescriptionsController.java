package com.thesis.prescriptionsapp.controllers;

import com.thesis.prescriptionsapp.api.PrescriptionsApi;
import com.thesis.prescriptionsapp.domain.PrescriptionEntity;
import com.thesis.prescriptionsapp.mapper.PrescriptionMapper;
import com.thesis.prescriptionsapp.models.Prescription;
import com.thesis.prescriptionsapp.repositories.PrescriptionRepository;
import com.thesis.prescriptionsapp.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpStatus.CREATED;
@RestController
public class PrescriptionsController implements PrescriptionsApi
{
    @Autowired
    PrescriptionService prescriptionService;

    @Override
    public ResponseEntity<Void> createPrescription(Prescription prescription)
    {
        System.out.println(prescription.toString());
        PrescriptionEntity prescriptionEntity = PrescriptionMapper.INSTANCE.mapTo(prescription);
        prescriptionService.addPrescription(prescriptionEntity);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    public ResponseEntity<Prescription> showPrescriptionById(Integer prescriptionId)
    {
        PrescriptionEntity prescriptionEntity = prescriptionService.getPrescriptionById(prescriptionId);
        Prescription prescription = PrescriptionMapper.INSTANCE.mapTo(prescriptionEntity);
        return ResponseEntity.accepted().body(prescription);
    }

    @Override
    public ResponseEntity<List<Prescription>> getAllPrescriptions()
    {
        Date date = new Date();
        List<Prescription> prescriptions = new ArrayList<>();
        Prescription prescription = new Prescription();
        prescription.setDoctor("Adrian");
        prescription.setUser("Damian");
        prescription.setCreatedAt(date);
        prescription.setName("IBUM");
        Prescription prescription2 = new Prescription();
        prescription2.setDoctor("Adrian2");
        prescription2.setUser("Damian2");
        prescription2.setCreatedAt(date);
        prescription2.setName("IBUM2");
        prescriptions.add(prescription);
        prescriptions.add(prescription2);
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }
}
