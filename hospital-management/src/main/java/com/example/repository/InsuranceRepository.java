package com.example.repository;

import com.example.entity.Insurance;
import com.example.entity.Patient;
import com.example.payload.request.InsuranceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
}
