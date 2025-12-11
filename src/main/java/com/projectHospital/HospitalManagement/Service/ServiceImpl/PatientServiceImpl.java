package com.projectHospital.HospitalManagement.Service.ServiceImpl;

import com.projectHospital.HospitalManagement.Dto.PatientDto;
import com.projectHospital.HospitalManagement.Entity.Patient;
import com.projectHospital.HospitalManagement.Mapper.PatientMapper;
import com.projectHospital.HospitalManagement.Repo.PatientRepository;
import com.projectHospital.HospitalManagement.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("error in getting data by id"));
    }

    @Override
    public Patient savePatient(PatientDto patientDto) {
        Patient patient = patientMapper.toEntity(patientDto);
        return patientRepository.save(patient);
    }

    @Override
    public List<PatientDto> getAllPatient() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toDto)
                .toList();
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("problem while updating"));
        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setGender(patientDto.getGender());
        patient.setBirthDate(patientDto.getBirthDate());

        Patient updatedPatient = patientRepository.save(patient);

        return patientMapper.toDto(updatedPatient);
    }

    @Override
    public List<PatientDto> findByEmail(String email) {
        return patientRepository.findByEmail(email)
                .stream()
                .map(patientMapper::toDto)
                .toList();
    }

    @Override
    public List<PatientDto> searchByName(String name) {

        return patientRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(patientMapper::toDto)
                .toList();
    }

    @Override
    public List<PatientDto> filterByGender(String gender) {
        return patientRepository.findByGenderIgnoreCase(gender)
                .stream()
                .map(patientMapper::toDto)
                .toList();
    }

    @Override
    public List<PatientDto> filterByBirthDateRange(LocalDate start, LocalDate end) {
        return patientRepository.findByBirthDateBetween(start,end)
                .stream()
                .map(patientMapper::toDto)
                .toList();
    }

}
