package com.learn.springboot.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // marks the class for spring bean and makes it available for dependency injection
// Prototype beans are lazy by default. No need to use Lazy initialization for prototype scope beans
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // by default the scope is singleton
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes. :)";
    }
}
