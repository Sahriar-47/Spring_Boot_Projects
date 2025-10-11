package com.example.service;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
    String saveEmployee(Employee employee);
    String updateEmployee(Employee employee);
    String deleteEmployee(Integer id);
    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployees();
}
