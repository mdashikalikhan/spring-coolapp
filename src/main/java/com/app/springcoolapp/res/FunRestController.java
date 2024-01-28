package com.app.springcoolapp.res;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${api.casa.account}")
    private String CASA_API;

    @Value("${api.postTransaction}")
    private String POST_TRANSACTION_API;

    /*@GetMapping("/")
    public String welcomeMessae(){
        return "Welcome to Cool Spring Boot Application";
    }*/

    @GetMapping("/status1")
    public String getStatus(){
        return "Status is OK";
    }

    @GetMapping("/casa")
    public String getCasaAPI(){
        return "API Name: " + this.CASA_API;
    }

    @GetMapping("/transaction")
    public String getTransactionAPI(){
        return "API Name: " + this.POST_TRANSACTION_API;
    }
}
