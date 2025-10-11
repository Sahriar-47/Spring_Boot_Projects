package com.example.controller;

import com.example.entity.Course;
import com.example.payload.request.CoursePayload;
import com.example.payload.response.CourseResponse;
import com.example.payload.response.ServiceResponse;
import com.example.service.CourseService;
import com.example.validator.CourseValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course")
    public ServiceResponse<CourseResponse> addCourse(@Valid @RequestBody CoursePayload coursePayload) {
        CourseValidator.validateCourseDate(coursePayload);
        CourseResponse courseResponse = courseService.saveCourse(coursePayload);
        ServiceResponse<CourseResponse> response = new ServiceResponse<>();
        response.setData(courseResponse);
        response.setStatusCode(HttpStatus.OK.value());

        return response;
    }

//    @PutMapping("/course/{id}")
//    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id) {
//        return new ResponseEntity<>(courseService.updateCourse(course, id), HttpStatus.OK);
//    }
//
//    @GetMapping("/course/{id}")
//    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
//        return new ResponseEntity<>(courseService.getCourse(id), HttpStatus.OK);
//    }
//
//    @GetMapping("/course")
//    public ResponseEntity<List<Course>> getCourses() {
//        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/course/{id}")
//    public ResponseEntity<String> deleteCourseById(@PathVariable Long id) {
//        return new ResponseEntity<>(courseService.deleteCourse(id), HttpStatus.OK);
//    }
}
