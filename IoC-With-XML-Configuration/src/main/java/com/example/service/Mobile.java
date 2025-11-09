package com.example.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Mobile {
    // Main driver method
    public static void main(String[] args){
        ApplicationContext appCntx = new ClassPathXmlApplicationContext("beans.xml");

        Sim sim = appCntx.getBean("sim", Sim.class);
        sim.calling();
        sim.data();
    }
}