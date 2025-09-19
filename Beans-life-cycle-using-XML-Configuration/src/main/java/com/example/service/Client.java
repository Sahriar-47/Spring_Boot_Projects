package com.example.service;
import com.example.beans.HelloWorld;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext cap = new ClassPathXmlApplicationContext("beans.xml");
        cap.close();
    }
}
