package com.learn.springboot.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component // marks the class for spring bean and makes it available for dependency injection
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // by default the scope is singleton
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes. :)";
    }
}
