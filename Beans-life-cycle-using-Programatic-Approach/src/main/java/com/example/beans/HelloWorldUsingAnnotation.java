package com.example.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class HelloWorldUsingAnnotation {
    @PostConstruct
    public void init() throws Exception {
        System.out.println("By using Annotation:");
        System.out.println("Bean has been instantiated and i am the init() method");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Container has been closed, and i am the destroy method");
    }
}
