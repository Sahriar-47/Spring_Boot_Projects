package com.example.service;

import com.example.entity.Appointment;
import com.example.payload.request.AppointmentDto;
import com.example.payload.response.AppointmentResponse;

public interface AppointmentService {
    AppointmentResponse createAppointment(AppointmentDto appointmentDto);
    AppointmentResponse getAppointment(Long id);
    AppointmentResponse updateAppointment(AppointmentDto appointmentDto, Long id);
    String deleteAppointment(Long id);
}
