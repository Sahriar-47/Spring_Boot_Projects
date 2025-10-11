package com.example.service.impl;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String saveEmployee(Employee employee) {
        Employee employeeEntity = employeeRepository.saveEmployee(employee);
        if(employeeEntity.getId() != null) {
            return "employee saved sucessfully. Employee ID: " + employeeEntity.getId();
        }
        return "Employee not saved";
    }

    @Override
    public String updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public String deleteEmployee(Integer id) {
        return "";
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }
}
