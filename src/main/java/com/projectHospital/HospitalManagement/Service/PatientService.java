package com.projectHospital.HospitalManagement.Service;


import com.projectHospital.HospitalManagement.Dto.PatientDto;
import com.projectHospital.HospitalManagement.Entity.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface PatientService {

    Patient getPatientById(Long id);

    Patient savePatient(PatientDto patientDto);

    List<PatientDto> getAllPatient();

    void deletePatient(Long id);

    PatientDto updatePatient(Long id, PatientDto patientDto);

    List<PatientDto> findByEmail(String email);

    List<PatientDto> searchByName(String name);

    List<PatientDto> filterByGender(String gender);

    List<PatientDto> filterByBirthDateRange(LocalDate start, LocalDate end);
}
