package com.example.demo.common.coach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfiguration {
    @Bean("swimCoach")
    public ICoach getSwimCoach() {
        return new SwimCoach();
    }
}
