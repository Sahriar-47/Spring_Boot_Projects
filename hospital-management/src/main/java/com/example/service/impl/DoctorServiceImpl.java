package com.example.service.impl;

import com.example.entity.Appointment;
import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.map.MapToResponse;
import com.example.payload.request.DoctorDto;
import com.example.payload.response.DoctorResponse;
import com.example.repository.AppointmentRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.DoctorRepository;
import com.example.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository, DepartmentRepository departmentRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DoctorResponse createDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setSpecialization(doctorDto.getSpecialization());

        if(doctorDto.getAppointmentIds() != null &&  !doctorDto.getAppointmentIds().isEmpty()) {
            List<Appointment> appointments = appointmentRepository.findAllById(doctorDto.getAppointmentIds());
            for (Appointment appointment : appointments) {
                appointment.setDoctor(doctor);
            }
            doctor.setAppointmentList(appointments);
        } else {
            doctor.setAppointmentList(null);
        }

        if(doctorDto.getDepartmentIds() != null &&  !doctorDto.getDepartmentIds().isEmpty()) {
            Set<Department>  departments = new HashSet<>();
            departmentRepository.findAllById(doctorDto.getDepartmentIds()).forEach(departments::add);
            for(Department department : departments) {
                department.getDoctors().add(doctor);
            }
            doctor.setDepartments(departments);
        } else {
            doctor.setDepartments(null);
        }

        Doctor savedDoctor = doctorRepository.save(doctor);
        return MapToResponse.mapFromDoctorToDoctorResponse(savedDoctor);
    }

    @Override
    public DoctorResponse getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()->
                new RuntimeException("doctor not found"));
        return MapToResponse.mapFromDoctorToDoctorResponse(doctor);
    }

    @Override
    public DoctorResponse updateDoctor(DoctorDto doctorDto, Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()->
                new RuntimeException("doctor not found"));
        doctor.setName(doctorDto.getName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setSpecialization(doctorDto.getSpecialization());

        if(doctorDto.getAppointmentIds() != null &&  !doctorDto.getAppointmentIds().isEmpty()) {
            List<Appointment> appointments = appointmentRepository.findAllById(doctorDto.getAppointmentIds());
            for (Appointment appointment : appointments) {
                appointment.setDoctor(doctor);
            }
            doctor.setAppointmentList(appointments);
        }

        if(doctorDto.getDepartmentIds() != null &&  !doctorDto.getDepartmentIds().isEmpty()) {
            Set<Department> departments = new HashSet<>();
            departmentRepository.findAllById(doctorDto.getDepartmentIds()).forEach(departments::add);
            for(Department department : departments) {
                department.getDoctors().add(doctor);
            }
            doctor.setDepartments(departments);
        }

        Doctor savedDoctor = doctorRepository.save(doctor);
        return MapToResponse.mapFromDoctorToDoctorResponse(savedDoctor);
    }

    @Override
    public DoctorResponse deleteDoctorById(Long id) {
        Doctor doctor =  doctorRepository.findById(id).orElseThrow(()->
                new RuntimeException("doctor not found"));

        if(doctor.getAppointmentList() != null && !doctor.getAppointmentList().isEmpty()) {
            List<Appointment> appointments = doctor.getAppointmentList();
            for (Appointment appointment : appointments) {
                appointment.setDoctor(null);
            }
            doctor.getAppointmentList().clear();
        }

        if(doctor.getDepartments() != null && !doctor.getDepartments().isEmpty()) {
            Set<Department> departments = doctor.getDepartments();
            for (Department department : departments) {
                department.getDoctors().remove(doctor);
            }
            doctor.getDepartments().clear();
        }

        return MapToResponse.mapFromDoctorToDoctorResponse(doctor);
    }
}
