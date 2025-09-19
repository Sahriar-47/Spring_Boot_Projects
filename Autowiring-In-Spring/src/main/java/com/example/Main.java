package com.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        City city = context.getBean("city", City.class);
        city.setId(47);
        city.setName("sylhet");
        State st = context.getBean("state", State.class);
        st.setName("sylhet");
        city.setS(st);

        city.showCityDetails();
    }
}
