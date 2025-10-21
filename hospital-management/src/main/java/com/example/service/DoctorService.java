package com.example.service;

import com.example.payload.request.DoctorDto;
import com.example.payload.response.DoctorResponse;

public interface DoctorService {
    DoctorResponse createDoctor(DoctorDto doctorDto);
    DoctorResponse getDoctorById(Long id);
    DoctorResponse updateDoctor(DoctorDto doctorDto, Long id);
    DoctorResponse deleteDoctorById(Long id);
}
