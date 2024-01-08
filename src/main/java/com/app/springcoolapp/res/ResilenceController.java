package com.app.springcoolapp.res;

import com.app.springcoolapp.service.ExternalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResilenceController {

    private final ExternalService externalService;

    public ResilenceController(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/invokeExternalService")
    public String invokeExternalService(){
        return externalService.callResilenceService();
    }
}
