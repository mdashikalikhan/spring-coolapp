package com.app.springcoolapp.res;

import com.app.springcoolapp.model.Coach;
import com.app.springcoolapp.model.Game;
import com.app.springcoolapp.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController implements Vehicle {

    private Coach myCoach;

    private Game game;

    public  DemoController(@Qualifier("tennisCoach") Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @Autowired
    private void setGameName(Game theGame){
        this.game = theGame;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public String getName() {
        return null;
    }

    @GetMapping("/getDailyWorkOut")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkOut();
    }

    @GetMapping("/getGameType")
    public String getGameName(){
        return game.getName();
    }
}
