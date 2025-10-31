package com.example.repository;

import com.example.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
