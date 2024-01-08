package com.app.springcoolapp.res;

import com.app.springcoolapp.model.Coach;
import com.app.springcoolapp.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {

    private Vehicle myVehicle;

    private Vehicle anotherVehicle;

    private Coach theCoach;


    @Autowired
    public BeanController(@Qualifier("car") Vehicle myVehicle,
                          @Qualifier("car") Vehicle anotherVehicle,
                          @Qualifier("car") Vehicle thirdVehicle) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myVehicle = myVehicle;
        this.anotherVehicle = anotherVehicle;
        if(myVehicle==anotherVehicle){
            System.out.println("myVehicle is equal to anotherVehicle " );
        } else{
            System.out.println("myVehicle != anotherVehicle");
        }
    }

    public void setCoach(Coach theCoach){
        this.theCoach = theCoach;
    }

    @GetMapping("/check")
    public  String check(){
        return "Comparing beans: myVehicle==anotherVehicle, " + (myVehicle==anotherVehicle);
    }
}
