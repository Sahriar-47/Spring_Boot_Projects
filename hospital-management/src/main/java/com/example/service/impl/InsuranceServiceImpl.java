package com.example.service.impl;

import com.example.entity.Insurance;
import com.example.entity.Patient;
import com.example.map.MapToResponse;
import com.example.payload.request.InsuranceDto;
import com.example.payload.response.InsuranceResponse;
import com.example.repository.InsuranceRepository;
import com.example.repository.PatientRepository;
import com.example.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    @Autowired
    public InsuranceServiceImpl(InsuranceRepository insuranceRepository, PatientRepository patientRepository) {
        this.insuranceRepository = insuranceRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public InsuranceResponse createInsurance(InsuranceDto insuranceDto) {
        //Optional<Patient> patient = patientRepository.findById(insuranceDto.getPatientId());

        Insurance insurance = new Insurance();

        //if(patient.isPresent()) {
            insurance.setId(insuranceDto.getId());
            insurance.setInsuranceNumber(insuranceDto.getInsuranceNumber());
            insurance.setInsuranceProvider(insuranceDto.getInsuranceProvider());
            insurance.setValidUntil(insuranceDto.getValidUntil());
            //insurance.setPatient(patient.get());

            Insurance savedInsurance = insuranceRepository.save(insurance);
            return MapToResponse.mapFromInsuranceToInsuranceResponse(savedInsurance);
//        } else {
//            throw new RuntimeException("Patient not found");
//        }
    }

    @Override
    public InsuranceResponse getInsurance(Long insuranceId) {
        Insurance insurance = insuranceRepository.findById(insuranceId).orElseThrow(() -> new RuntimeException("Insurance not found"));

        return MapToResponse.mapFromInsuranceToInsuranceResponse(insurance);
    }

    @Override
    public InsuranceResponse updateInsurance(InsuranceDto insuranceDto, Long insuranceId) {
        Insurance insurance = insuranceRepository.findById(insuranceId).orElseThrow(() -> new RuntimeException("Insurance not found"));
        Optional<Patient> patient = patientRepository.findById(insuranceDto.getPatientId());
        if(!patient.isPresent()) {
            throw new RuntimeException("Patient not found");
        }

        insurance.setPatient(patient.get());
        insurance.setValidUntil(insuranceDto.getValidUntil());
        insurance.setInsuranceProvider(insuranceDto.getInsuranceProvider());
        insurance.setInsuranceNumber(insuranceDto.getInsuranceNumber());

        insuranceRepository.save(insurance);
        return MapToResponse.mapFromInsuranceToInsuranceResponse(insurance);
    }

    @Override
    public String deleteInsurance(Long insuranceId) {
        Insurance insurance = insuranceRepository.findById(insuranceId).orElseThrow(() -> new RuntimeException("Insurance not found"));
        Patient patient = patientRepository.findByInsurance(insurance);
        patient.setInsurance(null);
        patientRepository.save(patient);

        insuranceRepository.delete(insurance);
        return "Insurance successfully deleted";
    }
}
