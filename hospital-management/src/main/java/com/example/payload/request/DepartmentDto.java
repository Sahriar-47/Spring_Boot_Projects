package com.example.payload.request;

import com.example.entity.Doctor;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {
    private Long id;
    private String name;
    private Set<Doctor> doctorIds;
}
