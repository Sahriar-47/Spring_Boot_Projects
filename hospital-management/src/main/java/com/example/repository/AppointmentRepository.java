package com.example.repository;

import com.example.entity.Appointment;
import com.example.payload.request.AppointmentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
