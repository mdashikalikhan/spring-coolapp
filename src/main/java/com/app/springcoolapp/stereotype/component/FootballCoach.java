package com.app.springcoolapp.stereotype.component;

import com.app.springcoolapp.model.Coach;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    public FootballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Play football daily";
    }
}
