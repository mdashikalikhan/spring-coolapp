package com.app.springcoolapp.stereotype.component;

import com.app.springcoolapp.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class Truck implements Vehicle {

    public Truck() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public void start() {
        System.out.println("Starting truck engine...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping truck engine...");
    }

    @Override
    public String getName() {
        return "Truck";
    }
}
