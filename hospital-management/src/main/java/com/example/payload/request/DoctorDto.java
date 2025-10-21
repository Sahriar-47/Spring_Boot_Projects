package com.example.payload.request;

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
public class DoctorDto {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private Set<Department> departmentIds;
    private List<Appointment> appointmentIds;
}
