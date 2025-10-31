package com.example.service;

import com.example.payload.request.DepartmentDto;
import com.example.payload.response.DepartmentResponse;

public interface DepartmentService {
    DepartmentResponse createDepartment(DepartmentDto departmentDto);
    DepartmentResponse getDepartmentById(Long id);
    DepartmentResponse updateDepartmentById(DepartmentDto departmentDto, Long id);
    String deleteDepartmentById(Long id);
}
