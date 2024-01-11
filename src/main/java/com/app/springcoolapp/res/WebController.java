package com.app.springcoolapp.res;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class WebController {
    private final String MVC_WELCOME_PAGE="MVCWelcome";
    @GetMapping("/welcome") public String welcomeMVC(Model model){
        model.addAttribute("serverTime", new Date());
        return MVC_WELCOME_PAGE;
    }
}
