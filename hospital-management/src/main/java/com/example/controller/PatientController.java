package com.example.controller;

import com.example.entity.Patient;
import com.example.payload.request.PatientDto;
import com.example.payload.response.PatientResponse;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class PatientController {
    PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patient/create")
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientDto patientDto){
        PatientResponse patientResponse = patientService.createPatient(patientDto);
        return new ResponseEntity<>(patientResponse,HttpStatus.OK);
    }

    @GetMapping("/patient/get/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long id){
        PatientResponse patientResponse = patientService.getPatientById(id);
        return new ResponseEntity<>(patientResponse,HttpStatus.OK);
    }

    @PutMapping("/patient/update/{id}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long id,
                                                         @RequestBody PatientDto patientDto){
        PatientResponse patientResponse = patientService.updatePatient(patientDto,id);
        return new ResponseEntity<>(patientResponse,HttpStatus.OK);
    }

    @DeleteMapping("/patient/delete/{id}")
    public ResponseEntity<PatientResponse> deletePatient(@PathVariable Long id){
        PatientResponse patientResponse = patientService.deletePatientById(id);
        return new ResponseEntity<>(patientResponse,HttpStatus.OK);
    }

}
