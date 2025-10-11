package com.example.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private String courseName;
    private String courseDescription;
    private LocalDate courseStartDate;
    private LocalDate courseEndDate;
}
