package com.projectHospital.HospitalManagement.Controller;

import com.projectHospital.HospitalManagement.Dto.PatientDto;
import com.projectHospital.HospitalManagement.Entity.Patient;
import com.projectHospital.HospitalManagement.Mapper.PatientMapper;
import com.projectHospital.HospitalManagement.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping("/patient")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        PatientDto patientDto = patientMapper.toDto(patient);
        return ResponseEntity.status(201).body(patientService.savePatient(patientDto));
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientDto>> allPatient() {
        return ResponseEntity.ok(patientService.getAllPatient());
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.status(200).body("Patient deleted successfully");
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id,
                                    @RequestBody Patient patient) {
        PatientDto patientDto = patientMapper.toDto(patient);
        return ResponseEntity.ok().body(patientService.updatePatient(id, patientDto));
    }


    // -----------------------
    // SEARCH & FILTER APIs
    // -----------------------

    // 1️⃣ Find by Email
    @GetMapping("/patients/email/{email}")
    public List<PatientDto> getByEmail(@PathVariable String email) {
        return patientService.findByEmail(email);
    }

    // 2️⃣ Search by Name (partial match)
    @GetMapping("/patients/search")
    public List<PatientDto> searchByName(@RequestParam String name) {
        return patientService.searchByName(name);
    }

    // 3️⃣ Filter by Gender
    @GetMapping("/patients/filter")
    public List<PatientDto> filterByGender(@RequestParam String gender) {
        return patientService.filterByGender(gender);
    }

    // 4️⃣ Filter by DOB range
    @GetMapping("/patients/dob")
    public List<PatientDto> filterByDOB(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return patientService.filterByBirthDateRange(start, end);
    }

}
