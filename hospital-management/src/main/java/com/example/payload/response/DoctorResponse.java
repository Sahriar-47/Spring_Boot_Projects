package com.example.payload.response;

import com.example.entity.Appointment;
import com.example.entity.Department;
import lombok.*;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponse {
    private String name;
    private String specialization;
    private String email;
    private Set<Long> departmentIds;
    private List<Long> appointmentIds;
}