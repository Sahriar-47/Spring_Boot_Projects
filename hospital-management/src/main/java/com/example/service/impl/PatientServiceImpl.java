package com.example.service.impl;

import com.example.entity.Insurance;
import com.example.entity.Patient;
import com.example.map.MapToResponse;
import com.example.payload.request.PatientDto;
import com.example.payload.response.PatientResponse;
import com.example.repository.InsuranceRepository;
import com.example.repository.PatientRepository;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    PatientRepository patientRepository;
    InsuranceRepository insuranceRepository;
    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, InsuranceRepository insuranceRepository) {
        this.patientRepository = patientRepository;
        this.insuranceRepository = insuranceRepository;
    }


    @Override
    public PatientResponse createPatient(PatientDto patientDto) {
        Optional<Insurance> insurance = insuranceRepository.findById(patientDto.getInsuranceId());

        if(insurance.isPresent()){
            Patient patient = new Patient();

            patient.setId(patient.getId());
            patient.setName(patientDto.getName());
            patient.setEmail(patientDto.getEmail());
            patient.setMobileNumber(patientDto.getMobileNumber());
            patient.setGender(patientDto.getGender());
            patient.setInsurance(insurance.get());

            Patient savedPatient = patientRepository.save(patient);
            return MapToResponse.mapFromPatientToPatientResponse(savedPatient);

        } else {
            throw new RuntimeException("Insurance not found");
        }
    }

    @Override
    public PatientResponse getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));

        return MapToResponse.mapFromPatientToPatientResponse(patient);
    }

    @Override
    public PatientResponse updatePatient(PatientDto patientDto, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        Insurance insurance = insuranceRepository.findById(patientDto.getInsuranceId()).orElseThrow(() -> new RuntimeException("Insurance not found"));

        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setMobileNumber(patientDto.getMobileNumber());
        patient.setGender(patientDto.getGender());
        patient.setInsurance(insurance);

        patientRepository.save(patient);
        return MapToResponse.mapFromPatientToPatientResponse(patient);
    }

    @Override
    public PatientResponse deletePatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));

        Insurance insurance = insuranceRepository.findByPatient(patient);
        insurance.setPatient(null);
        insuranceRepository.save(insurance);

        patientRepository.delete(patient);
        return MapToResponse.mapFromPatientToPatientResponse(patient);
    }
}
