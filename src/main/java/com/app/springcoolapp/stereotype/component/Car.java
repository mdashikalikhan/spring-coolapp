package com.app.springcoolapp.stereotype.component;

import com.app.springcoolapp.model.Vehicle;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Car implements Vehicle {

    public Car() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public void start() {
        System.out.println("Starting car engine...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping car engine...");
    }

    @Override
    public String getName() {
        return "Car";
    }
}
