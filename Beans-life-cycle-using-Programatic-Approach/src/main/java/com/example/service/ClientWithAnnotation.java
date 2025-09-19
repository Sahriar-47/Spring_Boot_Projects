package com.example.service;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientWithAnnotation {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext cap = new ClassPathXmlApplicationContext("beansWithAnnotation.xml");

        cap.close();
    }
}
