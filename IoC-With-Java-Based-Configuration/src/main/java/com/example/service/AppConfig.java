package com.example.service;

import com.example.service.impl.Airtel;
import com.example.service.impl.Banglalink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Sim sim () {
        return new Airtel();
    }
}
