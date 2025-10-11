package com.example.validator;

import com.example.exception.ClientException;
import com.example.payload.request.CoursePayload;

public class CourseValidator {
    public static void validateCourseDate(CoursePayload coursePayload) {
        if(coursePayload.getCourseStartDate().isAfter(coursePayload.getCourseEndDate())) {
            throw new ClientException("Course start date cannot be after course end date");
        }
    }
}
