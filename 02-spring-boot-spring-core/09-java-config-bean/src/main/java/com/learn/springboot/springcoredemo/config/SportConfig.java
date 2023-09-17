package com.learn.springboot.springcoredemo.config;

import com.learn.springboot.springcoredemo.common.Coach;
import com.learn.springboot.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic") // Giving the bean id as aquatic here but bean id defaults to the method name
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
