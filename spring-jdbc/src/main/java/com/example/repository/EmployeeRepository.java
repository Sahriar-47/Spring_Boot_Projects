package com.example.repository;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee deleteEmployee(Integer id);
    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployees();
}
