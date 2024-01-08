package com.app.springcoolapp.stereotype.component;

import com.app.springcoolapp.model.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Daily batting practice for 2 hours";
    }

    @PostConstruct
    public void doStartUpJob(){
        System.out.println("startup job: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doCleanUpbeforeDestroy(){
        System.out.println("ending cleanup job: " + getClass().getSimpleName());
    }
}
