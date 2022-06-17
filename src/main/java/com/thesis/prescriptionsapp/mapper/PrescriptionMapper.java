package com.thesis.prescriptionsapp.mapper;

import com.thesis.prescriptionsapp.domain.PrescriptionEntity;
import com.thesis.prescriptionsapp.models.Prescription;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrescriptionMapper
{
    PrescriptionMapper INSTANCE = Mappers.getMapper(PrescriptionMapper.class);

    @Mappings({
            @Mapping(target = "prescriptionId", source = "id"),
            @Mapping(target = "prescriptionName", source = "name"),
            @Mapping(target = "prescriptionDoctor", source = "doctor"),
            @Mapping(target = "prescriptionUser", source = "user"),
            @Mapping(target = "prescriptionCreatedAt", source = "createdAt")
    })
    PrescriptionEntity mapTo(Prescription prescription);

    @InheritInverseConfiguration
    Prescription mapTo(PrescriptionEntity prescriptionEntity);
}
