package com.projectHospital.HospitalManagement.Repo;

import com.projectHospital.HospitalManagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContainingIgnoreCase(String name);

    List<Patient> findByEmail(String email);

    List<Patient> findByGenderIgnoreCase(String gender);

    List<Patient> findByBirthDateBetween(LocalDate start, LocalDate end);
}
