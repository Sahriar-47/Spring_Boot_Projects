package com.example.beans;

public class HelloWorld {
    //custom init() method
    public void init() throws Exception {
        System.out.println("Bean helloworld has been instantiated, and i am the init() method");
    }

    //custom destroy() method
    public void destroy() throws Exception {
        System.out.println("Container has been closed, and i am the destroy() method");
    }
}
