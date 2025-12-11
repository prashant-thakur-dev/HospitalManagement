package com.projectHospital.HospitalManagement.Mapper;

import com.projectHospital.HospitalManagement.Dto.PatientDto;
import com.projectHospital.HospitalManagement.Entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    public Patient toEntity(PatientDto dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setBirthDate(dto.getBirthDate());
        patient.setEmail(dto.getEmail());
        patient.setGender(dto.getGender());
        return patient;
    }

    public PatientDto toDto(Patient patient) {
        PatientDto dto = new PatientDto();
        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setBirthDate(patient.getBirthDate());
        dto.setEmail(patient.getEmail());
        dto.setGender(patient.getGender());
        return dto;
    }
}
