package com.example.map;

import com.example.entity.Course;
import com.example.payload.request.CoursePayload;
import com.example.payload.response.CourseResponse;

import java.util.Random;

public class CourseMapper {
    public static Course mapFromCoursePayloadToCourse(CoursePayload coursePayload) {
        Course course = new Course();

        course.setCourseId(String.valueOf(new Random().nextLong()));
        course.setCourseName(coursePayload.getCourseName());
        course.setCourseDescription(coursePayload.getCourseDescription());
        course.setCourseStartDate(coursePayload.getCourseStartDate());
        course.setCourseEndDate(coursePayload.getCourseEndDate());
        course.setCourseStatus(coursePayload.getCourseStatus());
        return course;
    }

    public static CourseResponse mapFromCourseToCourseResponse(Course course) {
        CourseResponse courseResponse = new CourseResponse();

        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setCourseDescription(course.getCourseDescription());
        courseResponse.setCourseStartDate(course.getCourseStartDate());
        courseResponse.setCourseEndDate(course.getCourseEndDate());
        return courseResponse;

    }
}
