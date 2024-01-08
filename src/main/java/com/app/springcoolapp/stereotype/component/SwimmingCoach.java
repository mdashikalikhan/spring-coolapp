package com.app.springcoolapp.stereotype.component;

import com.app.springcoolapp.model.Coach;

public class SwimmingCoach implements Coach {

    @Override
    public String getDailyWorkOut() {
        return "Swim 1000 meters as warmup";
    }
}
