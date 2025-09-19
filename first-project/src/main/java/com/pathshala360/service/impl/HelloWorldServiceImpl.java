package com.pathshala360.service.impl;

import com.pathshala360.service.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String hello() {
        return "hello world!";
    }
}
