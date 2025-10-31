package com.example.service.impl;

import com.example.entity.Department;
import com.example.entity.Doctor;
import com.example.map.MapToResponse;
import com.example.payload.request.DepartmentDto;
import com.example.payload.response.DepartmentResponse;
import com.example.repository.DepartmentRepository;
import com.example.repository.DoctorRepository;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DoctorRepository doctorRepository) {
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DepartmentResponse createDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.getName());

        if(departmentDto.getDoctorIds() != null && !departmentDto.getDoctorIds().isEmpty()) {
            Set<Doctor> doctors = new HashSet<>();
            doctorRepository.findAllById(departmentDto.getDoctorIds()).forEach(doctors::add);
            for(Doctor doctor : doctors) {
                doctor.getDepartments().add(department);
            }
            department.setDoctors(doctors);
        } else {
            department.setDoctors(null);
        }

        Department savedDepartment = departmentRepository.save(department);
        return MapToResponse.mapFromDepartmentToDepartmentResponse(savedDepartment);
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        return null;
    }

    @Override
    public DepartmentResponse updateDepartmentById(DepartmentDto departmentDto, Long id) {
        return null;
    }

    @Override
    public String deleteDepartmentById(Long id) {
        return "";
    }
}
