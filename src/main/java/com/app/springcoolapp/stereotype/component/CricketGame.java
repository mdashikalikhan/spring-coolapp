package com.app.springcoolapp.stereotype.component;

import com.app.springcoolapp.model.Game;
import org.springframework.stereotype.Component;

@Component
public class CricketGame implements Game {

    public CricketGame() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getName() {
        return "Cricket game";
    }
}
