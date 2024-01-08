package com.app.springcoolapp.model;

public interface Vehicle {
    public void start();

    public void stop();

    public String getName();

    /*default void blowHorn(){
        System.out.println("Blowing Horn");
    }*/
}
