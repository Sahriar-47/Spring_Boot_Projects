package com.example.service.impl;

import com.example.entity.Doctor;
import com.example.map.MapToResponse;
import com.example.payload.request.DoctorDto;
import com.example.payload.response.DoctorResponse;
import com.example.repository.DoctorRepository;
import com.example.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    DoctorRepository doctorRepository;
    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorResponse createDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();

        //doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setSpecialization( doctorDto.getSpecialization());

        Doctor savedDoctor = doctorRepository.save(doctor);
        return MapToResponse.mapFromDoctorToDoctorResponse(savedDoctor);
    }

    @Override
    public DoctorResponse getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("doctor not found"));
        return MapToResponse.mapFromDoctorToDoctorResponse(doctor);
    }

    @Override
    public DoctorResponse updateDoctor(DoctorDto doctorDto, Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new RuntimeException("doctor not found"));
        doctor.setName(doctorDto.getName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setSpecialization(doctorDto.getSpecialization());

        Doctor savedDoctor = doctorRepository.save(doctor);
        return MapToResponse.mapFromDoctorToDoctorResponse(savedDoctor);
    }

    @Override
    public DoctorResponse deleteDoctorById(Long id) {
        return null;
    }
}
