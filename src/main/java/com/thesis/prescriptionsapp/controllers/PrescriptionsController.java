package com.thesis.prescriptionsapp.controllers;

import com.thesis.prescriptionsapp.api.PrescriptionsApi;
import com.thesis.prescriptionsapp.models.Prescription;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PrescriptionsController implements PrescriptionsApi {
    @Override
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        Date date = new Date();
        OffsetDateTime offsetDateTime = date.toInstant().atOffset(ZoneOffset.UTC);
        List<Prescription> prescriptions = new ArrayList<>();
        Prescription prescription = new Prescription();
        prescription.setPrescriptionDoctor("Adrian");
        prescription.setPrescriptionUser("Damian");
        prescription.setDatetime(offsetDateTime);
        prescription.setName("IBUM");
        Prescription prescription2 = new Prescription();
        prescription2.setPrescriptionDoctor("Adrian2");
        prescription2.setPrescriptionUser("Damian2");
        prescription2.setDatetime(offsetDateTime);
        prescription2.setName("IBUM2");
        prescriptions.add(prescription);
        prescriptions.add(prescription2);
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }
}
