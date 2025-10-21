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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Patient> patient = patientRepository.findById(appointmentDto.getPatientId());
        Optional<Doctor> doctor = doctorRepository.findById(appointmentDto.getDoctorId());

        if(patient.isPresent() &&  doctor.isPresent()){
            Appointment appointment = new Appointment();
            appointment.setId(appointmentDto.getId());
            appointment.setAppointmentDateTime(appointmentDto.getAppointmentDateTime());
            appointment.setAppointmentReason(appointmentDto.getAppointmentReason());
            appointment.setPatient(patient.get());
            appointment.setDoctor(doctor.get());

            Appointment savedAppointment = appointmentRepository.save(appointment);
            return MapToResponse.mapFromAppointmentToAppointmentResponse(savedAppointment);
        } else {
            throw new RuntimeException("Patient not found");
        }
    }

    @Override
    public AppointmentResponse getAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if(appointment == null){
            throw new RuntimeException("Appointment not found");
        }
        else {
            return MapToResponse.mapFromAppointmentToAppointmentResponse(appointment);
        }
    }

    @Override
    public AppointmentResponse updateAppointment(AppointmentDto appointmentDto, Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if(appointment == null){
            throw new RuntimeException("Appointment not found");
        } else {
            appointment.setAppointmentDateTime(appointmentDto.getAppointmentDateTime());
            appointment.setAppointmentReason(appointmentDto.getAppointmentReason());
            appointment.setPatient(patientRepository.findById(appointmentDto.getPatientId()).orElse(null));
            appointment.setDoctor(doctorRepository.findById(appointmentDto.getDoctorId()).orElse(null));

            Appointment updatedAppointment = appointmentRepository.save(appointment);
            return MapToResponse.mapFromAppointmentToAppointmentResponse(updatedAppointment);
        }
    }


    @Override
    public String deleteAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if(appointment == null){
            throw new RuntimeException("Appointment not found");
        } else {
            appointmentRepository.delete(appointment);
            return "Appointment has been deleted";
        }
    }
}
