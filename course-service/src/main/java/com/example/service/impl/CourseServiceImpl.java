package com.example.service.impl;

import com.example.entity.Course;
import com.example.map.CourseMapper;
import com.example.payload.request.CoursePayload;
import com.example.payload.response.CourseResponse;
import com.example.repository.CourseRepository;
import com.example.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CourseServiceImpl implements CourseService {
    List<Course> courseList = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);

    private final CourseRepository courseRepository;
    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public CourseResponse saveCourse(CoursePayload coursePayload) {
        Course courseEntity = CourseMapper.mapFromCoursePayloadToCourse(coursePayload);
        Course savedCourseEntity = courseRepository.save(courseEntity);
        LOGGER.info("course saved successfully");
        CourseResponse courseResponse =  CourseMapper.mapFromCourseToCourseResponse(savedCourseEntity);
        return courseResponse;
    }

//    @Override
//    public Course getCourse(Long id) {
//        for(Course course: courseList) {
//            if(course.getCourseId().equals(id)) {
//                return course;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public List<Course> getCourses() {
//        return courseList;
//    }
//
//    @Override
//    public String deleteCourse(Long id) {
//        boolean isDeleted = courseList.removeIf(course -> course.getCourseId().equals(id));
//        if(isDeleted) {
//            return "Deleted course";
//        }
//        return "Course not found";
//    }
//
//    @Override
//    public Course updateCourse(Course course, Long id) {
//        Course courseToUpdate = getCourse(id);
//        courseToUpdate.setCourseDescription(course.getCourseDescription());
//        courseToUpdate.setCourseName(course.getCourseName());
//        courseToUpdate.setCourseStartDate(course.getCourseStartDate());
//        courseToUpdate.setCourseEndDate(course.getCourseEndDate());
//        return courseToUpdate;
//    }
}
