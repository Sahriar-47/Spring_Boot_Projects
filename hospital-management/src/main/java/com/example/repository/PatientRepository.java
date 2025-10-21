package com.example.repository;

import com.example.entity.Insurance;
import com.example.entity.Patient;
import com.example.payload.request.PatientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByInsurance(Insurance insurance);
}
//interface PatientDtoRepository extends JpaRepository<PatientDto,Long> {
//}
