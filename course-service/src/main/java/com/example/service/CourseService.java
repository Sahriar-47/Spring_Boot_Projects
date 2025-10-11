package com.example.service;

import com.example.entity.Course;
import com.example.payload.request.CoursePayload;
import com.example.payload.response.CourseResponse;

import java.util.List;

public interface CourseService {
    CourseResponse saveCourse(CoursePayload coursePayload);
//    Course getCourse(Long id);
//    List<Course> getCourses();
//    String deleteCourse(Long id);
//    Course updateCourse(Course course, Long id);
}
