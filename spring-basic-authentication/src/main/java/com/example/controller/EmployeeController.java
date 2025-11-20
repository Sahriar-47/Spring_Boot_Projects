package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    public String welcomeMessage(){
        return "Welcome to Spring Boot Application";
    }

    @GetMapping("/public")
    public String getPublicResource(){
        return "public resource";
    }
}
