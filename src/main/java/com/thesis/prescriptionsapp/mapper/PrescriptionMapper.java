package com.thesis.prescriptionsapp.mapper;

import com.thesis.prescriptionsapp.domain.PrescriptionEntity;
import com.thesis.prescriptionsapp.models.Prescription;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

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
    @Named("prescriptionToEntity")
    PrescriptionEntity mapToEntity(Prescription prescription);

    @InheritInverseConfiguration
    @Named("entityToPrescription")
    Prescription mapToDto(PrescriptionEntity prescriptionEntity);

    @IterableMapping(qualifiedByName = "entityToPrescription")
    List<Prescription> mapToDtoList(List<PrescriptionEntity> prescriptionEntities);
}
