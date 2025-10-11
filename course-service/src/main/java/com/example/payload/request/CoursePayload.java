package com.example.payload.request;

import com.example.annotations.CourseStatusValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoursePayload {
    @NotBlank(message = "Course name can't be null or blank.")
    private String courseName;
    @NotBlank(message = "Course description can't be null or blank.")
    private String courseDescription;
    @NotNull(message = "Course start date can't be null.")
    private LocalDate courseStartDate;
    @NotNull(message = "Course end date can't be null.")
    private LocalDate courseEndDate;
    @CourseStatusValidator
    private String courseStatus;
}
