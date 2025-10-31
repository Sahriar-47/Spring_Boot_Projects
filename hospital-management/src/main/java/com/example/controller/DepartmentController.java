package com.example.controller;

import com.example.entity.Department;
import com.example.payload.request.DepartmentDto;
import com.example.payload.response.DepartmentResponse;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v5")
public class DepartmentController {
    private final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/department/create")
    public ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentResponse departmentResponse = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(departmentResponse,HttpStatus.OK);
    }
}
