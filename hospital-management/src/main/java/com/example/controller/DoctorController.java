package com.example.controller;


import com.example.entity.Doctor;
import com.example.payload.request.DoctorDto;
import com.example.payload.response.DoctorResponse;
import com.example.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v4")
public class DoctorController {
    DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/doctor/create")
    public ResponseEntity<DoctorResponse> createDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorResponse doctorResponse = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(doctorResponse, HttpStatus.OK);
    }

    @GetMapping("/doctor/get/{id}")
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable Long id) {
        DoctorResponse doctorResponse = doctorService.getDoctorById(id);
        return new ResponseEntity<>(doctorResponse, HttpStatus.OK);
    }

    @PutMapping("/doctor/update/{id}")
    public ResponseEntity<DoctorResponse> updateDoctor(@PathVariable Long id,
                                                       @RequestBody DoctorDto doctorDto) {
        DoctorResponse doctorResponse = doctorService.updateDoctor(doctorDto, id);
        return new ResponseEntity<>(doctorResponse, HttpStatus.OK);
    }
}
