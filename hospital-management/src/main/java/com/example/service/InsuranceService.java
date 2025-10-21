package com.example.service;

import com.example.entity.Insurance;
import com.example.payload.request.InsuranceDto;
import com.example.payload.response.InsuranceResponse;

public interface InsuranceService {
    InsuranceResponse createInsurance(InsuranceDto insuranceDto);
    InsuranceResponse getInsurance(Long insuranceId);
    InsuranceResponse updateInsurance(InsuranceDto insuranceDto, Long insuranceId);
    String deleteInsurance(Long insuranceId);

}
