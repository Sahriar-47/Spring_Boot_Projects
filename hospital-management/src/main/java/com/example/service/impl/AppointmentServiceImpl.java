package com.example.service.impl;

import com.example.entity.Appointment;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.map.MapToResponse;
import com.example.payload.request.AppointmentDto;
import com.example.payload.response.AppointmentResponse;
import com.example.repository.AppointmentRepository;
import com.example.repository.DoctorRepository;
import com.example.repository.PatientRepository;
import com.example.service.AppointmentService;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public AppointmentResponse createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(appointmentDto.getAppointmentDateTime());
        appointment.setAppointmentReason(appointmentDto.getAppointmentReason());

        if(appointmentDto.getDoctorId() != null) {
            Doctor doctor = doctorRepository.findById(appointmentDto.getDoctorId()).orElseThrow(()->
                    new RuntimeException("doctor not found"));
            appointment.setDoctor(doctor);
            doctor.getAppointmentList().add(appointment);
        } else {
            appointment.setDoctor(null);
        }
        if(appointmentDto.getPatientId() != null) {
            Patient patient = patientRepository.findById(appointmentDto.getPatientId()).orElseThrow(()->
                    new  RuntimeException("patient not found"));
            appointment.setPatient(patient);
            patient.getAppointments().add(appointment);
        } else {
            appointment.setPatient(null);
        }

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return MapToResponse.mapFromAppointmentToAppointmentResponse(savedAppointment);
    }

    @Override
    public AppointmentResponse getAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(()->
                new RuntimeException("appointment not found"));

        return MapToResponse.mapFromAppointmentToAppointmentResponse(appointment);
    }

    @Override
    public AppointmentResponse updateAppointment(AppointmentDto appointmentDto, Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(()->
                new RuntimeException("appointment not found"));

        appointment.setAppointmentDateTime(appointmentDto.getAppointmentDateTime());
        appointment.setAppointmentReason(appointmentDto.getAppointmentReason());

        if(appointmentDto.getDoctorId() != null) {
            Doctor doctor = doctorRepository.findById(appointmentDto.getDoctorId()).orElseThrow(()->
                    new RuntimeException("doctor not found"));
            appointment.setDoctor(doctor);
            doctor.getAppointmentList().add(appointment);
        } else {
            appointment.setDoctor(null);
        }
        if(appointmentDto.getPatientId() != null) {
            Patient patient = patientRepository.findById(appointmentDto.getPatientId()).orElseThrow(()->
                    new RuntimeException("patient not found"));
            appointment.setPatient(patient);
            patient.getAppointments().add(appointment);
        } else {
            appointment.setPatient(null);
        }

        Appointment updatedAppointment = appointmentRepository.save(appointment);
        return MapToResponse.mapFromAppointmentToAppointmentResponse(updatedAppointment);
    }

    @Override
    public String deleteAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(()->
                new  RuntimeException("appointment not found"));

        if(appointment.getDoctor() != null) {
            appointment.setDoctor(null);
            appointment.getDoctor().getAppointmentList().remove(appointment);
        }
        if(appointment.getPatient() != null) {
            appointment.setPatient(null);
            appointment.getPatient().getAppointments().remove(appointment);
        }

        appointmentRepository.delete(appointment);
        return "Appointment has been deleted";
    }
}
