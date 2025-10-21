package com.example.controller;

import com.example.payload.request.AppointmentDto;
import com.example.payload.response.AppointmentResponse;
import com.example.service.AppointmentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/appointment/create")
    public ResponseEntity<AppointmentResponse> saveAppointment(@RequestBody AppointmentDto appointmentDto) {
        AppointmentResponse appointmentResponse = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(appointmentResponse, HttpStatus.OK);
    }

    @PutMapping("/appointment/update/{id}")
    public ResponseEntity<AppointmentResponse> updateAppointment(@PathVariable Long id,
                                                                 @RequestBody AppointmentDto appointmentDto) {
        AppointmentResponse appointmentResponse = appointmentService.updateAppointment(appointmentDto, id);
        return new ResponseEntity<>(appointmentResponse, HttpStatus.OK);
    }

    @GetMapping("/appointment/get/{id}")
    public ResponseEntity<AppointmentResponse> getAppointment(@PathVariable Long id) {
        AppointmentResponse appointmentResponse = appointmentService.getAppointment(id);
        return new ResponseEntity<>(appointmentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/appointment/delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Appointment has been deleted", HttpStatus.OK);
    }
}
