package com.example.entity;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private Long id;
    private String Name;
    private String designation;
    private String email;
    private LocalDate dateOfJoining;
}
