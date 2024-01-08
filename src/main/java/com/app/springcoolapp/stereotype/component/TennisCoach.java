package com.app.springcoolapp.stereotype.component;

import com.app.springcoolapp.model.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Skillup your forehand shots";
    }
}
