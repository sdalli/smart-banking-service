package com.sesami.smart_banking_service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomWebClient customWebClient() {
        return new CustomWebClient();
    }
}
