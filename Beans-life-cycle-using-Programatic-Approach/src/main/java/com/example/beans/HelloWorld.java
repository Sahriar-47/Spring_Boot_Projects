package com.example.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class HelloWorld implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("By using xml configuration:");
        System.out.println("Bean has been instantiated and i am the init() method");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Container has been closed, and i am the destroy method");
    }
}
