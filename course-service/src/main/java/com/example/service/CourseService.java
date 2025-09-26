package com.example.service;

import com.example.entity.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    Course getCourse(Long id);
    List<Course> getCourses();
    String deleteCourse(Long id);
    Course updateCourse(Course course, Long id);
}
