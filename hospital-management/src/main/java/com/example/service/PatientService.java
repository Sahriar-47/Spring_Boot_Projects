package com.example.service;

import com.example.entity.Patient;
import com.example.payload.request.PatientDto;
import com.example.payload.response.PatientResponse;

public interface PatientService {
    PatientResponse createPatient(PatientDto patientDto);
    PatientResponse getPatientById(Long id);
    PatientResponse updatePatient(PatientDto patientDto, Long patientId);
    PatientResponse deletePatientById(Long id);
}
