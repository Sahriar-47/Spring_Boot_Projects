package com.example.controller;

import com.example.payload.request.InsuranceDto;
import com.example.payload.response.InsuranceResponse;
import com.example.repository.InsuranceRepository;
import com.example.service.InsuranceService;
import com.example.service.impl.InsuranceServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class InsuranceController {
    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/insurance/create")
    public ResponseEntity<InsuranceResponse> createInsurance(@RequestBody InsuranceDto insuranceDto) {
        InsuranceResponse insuranceResponse = insuranceService.createInsurance(insuranceDto);
        return new ResponseEntity<>(insuranceResponse,HttpStatus.OK);
    }

    @PutMapping("/insurance/update/{id}")
    public ResponseEntity<InsuranceResponse> updateInsurance(@PathVariable Long id,
                                                             @RequestBody InsuranceDto insuranceDto) {
        InsuranceResponse insuranceResponse = insuranceService.updateInsurance(insuranceDto, id);
        return new ResponseEntity<>(insuranceResponse,HttpStatus.OK);
    }

    @GetMapping("/insurance/get/{id}")
    public ResponseEntity<InsuranceResponse> getInsurance(@PathVariable Long id) {
        InsuranceResponse insuranceResponse = insuranceService.getInsurance(id);
        return new ResponseEntity<>(insuranceResponse,HttpStatus.OK);
    }

    @DeleteMapping("/insurance/delete/{id}")
    public ResponseEntity<String> deleteInsurance(@PathVariable Long id) {
        insuranceService.deleteInsurance(id);
        return new ResponseEntity<>("Insurance successfully deleted", HttpStatus.OK);
    }
}
