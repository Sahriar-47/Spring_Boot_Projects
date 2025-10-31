package com.example.map;

import com.example.entity.*;
import com.example.payload.response.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MapToResponse {
    public static AppointmentResponse mapFromAppointmentToAppointmentResponse(Appointment appointment) {
        AppointmentResponse appointmentResponse = new AppointmentResponse();

        appointmentResponse.setAppointmentDateTime(appointment.getAppointmentDateTime());
        appointmentResponse.setAppointmentReason(appointment.getAppointmentReason());

        if(appointment.getDoctor() != null) {
            appointmentResponse.setDoctorId(appointment.getDoctor().getId());
        } else {
            appointmentResponse.setDoctorId(null);
        }
        if(appointment.getPatient() != null) {
            appointmentResponse.setPatientId(appointment.getPatient().getId());
        } else {
            appointmentResponse.setPatientId(null);
        }

        return appointmentResponse;
    }

    public static InsuranceResponse mapFromInsuranceToInsuranceResponse(Insurance insurance) {
        InsuranceResponse insuranceResponse = new InsuranceResponse();

        insuranceResponse.setInsuranceProvider(insurance.getInsuranceProvider());
        insuranceResponse.setValidUntil(insurance.getValidUntil());
        insuranceResponse.setInsuranceNumber(insurance.getInsuranceNumber());
        if(insurance.getPatient() != null) {
            insuranceResponse.setPatientId(insurance.getPatient().getId());
        } else {
            insuranceResponse.setPatientId(null);
        }

        return insuranceResponse;
    }

    public static PatientResponse mapFromPatientToPatientResponse(Patient patient) {
        PatientResponse patientResponse = new PatientResponse();

        patientResponse.setName(patient.getName());
        patientResponse.setGender(patient.getGender());
        patientResponse.setEmail(patient.getEmail());
        patientResponse.setMobileNumber(String.valueOf(patient.getMobileNumber()));

        if(patient.getInsurance() != null){
            patientResponse.setInsuranceId(patient.getInsurance().getId());
        } else {
            patientResponse.setInsuranceId(null);
        }

        if(patient.getAppointments() != null){
            List<Long> appointmentIds = new ArrayList<>();
            for(Appointment appointment : patient.getAppointments()){
                appointmentIds.add(appointment.getId());
            }
            patientResponse.setAppointmentIds(appointmentIds);
        } else {
            patientResponse.setAppointmentIds(null);
        }

        return patientResponse;
    }

    public static DoctorResponse mapFromDoctorToDoctorResponse(Doctor doctor) {
        DoctorResponse doctorResponse = new DoctorResponse();

        doctorResponse.setName(doctor.getName());
        doctorResponse.setEmail(doctor.getEmail());
        doctorResponse.setSpecialization( doctor.getSpecialization());

        if(doctor.getDepartments() != null){
            Set<Long> departmentIds = new HashSet<>();
            for (Department department : doctor.getDepartments()) {
                departmentIds.add(department.getId());
            }
            doctorResponse.setDepartmentIds(departmentIds);
        } else {
            doctorResponse.setDepartmentIds(null);
        }

        if(doctor.getAppointmentList() != null){
            List<Long> appointmentIds = new ArrayList<>();
            for(Appointment appointment : doctor.getAppointmentList()){
                appointmentIds.add(appointment.getId());
            }
            doctorResponse.setAppointmentIds(appointmentIds);
        } else {
            doctorResponse.setAppointmentIds(null);
        }

        return doctorResponse;
    }

    public static DepartmentResponse mapFromDepartmentToDepartmentResponse(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setName(department.getName());

        if(department.getDoctors() != null){
            Set<Long> doctorIds = new HashSet<>();
            for(Doctor doctor : department.getDoctors()){
                doctorIds.add(doctor.getId());
            }
            departmentResponse.setDoctorIds(doctorIds);
        } else {
            departmentResponse.setDoctorIds(null);
        }

        return departmentResponse;
    }
}
