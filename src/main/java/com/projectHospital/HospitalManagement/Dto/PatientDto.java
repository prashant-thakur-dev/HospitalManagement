package com.projectHospital.HospitalManagement.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDto {

    private Long id;

    @NotBlank
    private String name;

    private LocalDate birthDate;

    @Email
    @NotBlank
    private String email;

    private String gender;
}
