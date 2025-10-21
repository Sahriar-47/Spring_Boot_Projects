package com.example.map;

import com.example.entity.Appointment;
import com.example.entity.Doctor;
import com.example.entity.Insurance;
import com.example.entity.Patient;
import com.example.payload.response.AppointmentResponse;
import com.example.payload.response.DoctorResponse;
import com.example.payload.response.InsuranceResponse;
import com.example.payload.response.PatientResponse;

public class MapToResponse {
    public static AppointmentResponse mapFromAppointmentToAppointmentResponse(Appointment appointment) {
        AppointmentResponse appointmentResponse = new AppointmentResponse();

        appointmentResponse.setId(appointment.getId());
        appointmentResponse.setAppointmentDateTime(appointment.getAppointmentDateTime());
        appointmentResponse.setAppointmentReason(appointment.getAppointmentReason());
        appointmentResponse.setPatientId(appointment.getPatient().getId());
        appointmentResponse.setDoctorId(appointment.getDoctor().getId());

        return appointmentResponse;
    }

    public static InsuranceResponse mapFromInsuranceToInsuranceResponse(Insurance insurance) {
        InsuranceResponse insuranceResponse = new InsuranceResponse();

        insuranceResponse.setId(insurance.getId());
        insuranceResponse.setInsuranceProvider(insurance.getInsuranceProvider());
        insuranceResponse.setValidUntil(insurance.getValidUntil());
        insuranceResponse.setInsuranceNumber(insurance.getInsuranceNumber());

        return insuranceResponse;
    }

    public static PatientResponse mapFromPatientToPatientResponse(Patient patient) {
        PatientResponse patientResponse = new PatientResponse();

        patientResponse.setId(patient.getId());
        patientResponse.setName(patient.getName());
        patientResponse.setGender(patient.getGender());
        patientResponse.setEmail(patient.getEmail());
        patientResponse.setMobileNumber(String.valueOf(patient.getMobileNumber()));
        patientResponse.setInsuranceId(patient.getInsurance().getId());

        return patientResponse;
    }

    public static DoctorResponse mapFromDoctorToDoctorResponse(Doctor doctor) {
        DoctorResponse doctorResponse = new DoctorResponse();

        doctorResponse.setId(doctor.getId());
        doctorResponse.setName(doctor.getName());
        doctorResponse.setEmail(doctor.getEmail());
        doctor.setSpecialization( doctor.getSpecialization());

        return doctorResponse;
    }
}
