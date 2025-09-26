package com.example.service.impl;

import com.example.entity.Course;
import com.example.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CourseServiceImpl implements CourseService {
    List<Course> courseList = new ArrayList<>();

    @Override
    public Course saveCourse(Course course) {
        course.setCourseId(new Random().nextLong());
        courseList.add(course);
        return course;
    }

    @Override
    public Course getCourse(Long id) {
        for(Course course: courseList) {
            if(course.getCourseId().equals(id)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> getCourses() {
        return courseList;
    }

    @Override
    public String deleteCourse(Long id) {
        boolean isDeleted = courseList.removeIf(course -> course.getCourseId().equals(id));
        if(isDeleted) {
            return "Deleted course";
        }
        return "Course not found";
    }

    @Override
    public Course updateCourse(Course course, Long id) {
        Course courseToUpdate = getCourse(id);
        courseToUpdate.setCourseDescription(course.getCourseDescription());
        courseToUpdate.setCourseName(course.getCourseName());
        courseToUpdate.setCourseStartDate(course.getCourseStartDate());
        courseToUpdate.setCourseEndDate(course.getCourseEndDate());
        return courseToUpdate;
    }
}
