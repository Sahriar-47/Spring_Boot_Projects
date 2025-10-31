package com.example.payload.response;

import com.example.entity.Doctor;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponse {
    private String name;
    private Set<Long> doctorIds;
}
