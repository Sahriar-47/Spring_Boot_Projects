package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long courseId;
    private String courseName;
    private String courseDescription;
    private LocalDate courseStartDate;
    private LocalDate courseEndDate;
}
