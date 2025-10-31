package com.example.service.impl;

import com.example.entity.Appointment;
import com.example.entity.Insurance;
import com.example.entity.Patient;
import com.example.map.MapToResponse;
import com.example.payload.request.PatientDto;
import com.example.payload.response.PatientResponse;
import com.example.repository.AppointmentRepository;
import com.example.repository.InsuranceRepository;
import com.example.repository.PatientRepository;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;
    private final AppointmentRepository appointmentRepository;
    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, InsuranceRepository insuranceRepository,
                              AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.insuranceRepository = insuranceRepository;
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public PatientResponse createPatient(PatientDto patientDto) {
        Patient patient = new Patient();

        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setMobileNumber(patientDto.getMobileNumber());
        patient.setGender(patientDto.getGender());

        if(patientDto.getInsuranceId() != null) {
            Insurance insurance = insuranceRepository.findById(patientDto.getInsuranceId()).orElseThrow(() ->
                    new RuntimeException("insurance id not found"));
            patient.setInsurance(insurance);
            insurance.setPatient(patient);
        }

        if(patientDto.getAppointmentIds() != null &&  !patientDto.getAppointmentIds().isEmpty()) {
            List<Appointment> appointments = appointmentRepository.findAllById(patientDto.getAppointmentIds());
            for(Appointment appointment : appointments) {
                appointment.setPatient(patient);
            }
            patient.setAppointments(appointments);
        }

        Patient savedPatient = patientRepository.save(patient);
        return MapToResponse.mapFromPatientToPatientResponse(savedPatient);
    }

    @Override
    public PatientResponse getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Patient not found"));

        return MapToResponse.mapFromPatientToPatientResponse(patient);
    }

    @Override
    public PatientResponse updatePatient(PatientDto patientDto, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() ->
                new RuntimeException("Patient not found"));

        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setMobileNumber(patientDto.getMobileNumber());
        patient.setGender(patientDto.getGender());

        if(patientDto.getInsuranceId() != null) {
            Insurance insurance = insuranceRepository.findById(patientDto.getInsuranceId()).orElseThrow(() ->
                    new RuntimeException("insurance not found"));
            patient.setInsurance(insurance);
            insurance.setPatient(patient);
        }

        if(patientDto.getAppointmentIds() != null && !patientDto.getAppointmentIds().isEmpty()) {
            List<Appointment> appointments = appointmentRepository.findAllById(patientDto.getAppointmentIds());
            for(Appointment appointment : appointments) {
                appointment.setPatient(patient);
            }
            patient.setAppointments(appointments);
        }

        Patient savedPatient = patientRepository.save(patient);
        return MapToResponse.mapFromPatientToPatientResponse(savedPatient);
    }

    @Override
    public PatientResponse deletePatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Patient not found"));

        Insurance insurance = patient.getInsurance();
        if(patient.getInsurance() != null) {
            insurance.setPatient(null);
            patient.setInsurance(null);
        }

        if(patient.getAppointments() != null) {
            List<Appointment> appointments =  patient.getAppointments();
            for(Appointment appointment : appointments) {
                appointment.setPatient(null);
            }
            patient.getAppointments().clear();
        }

        patientRepository.delete(patient);
        return MapToResponse.mapFromPatientToPatientResponse(patient);
    }
}
