package com.app.springcoolapp.stereotype.component;

import com.app.springcoolapp.model.Game;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballGame implements Game {

    public FootballGame() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getName() {
        return "Football Game";
    }
}
