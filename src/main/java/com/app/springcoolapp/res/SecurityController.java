package com.app.springcoolapp.res;

import com.app.springcoolapp.model.LoginForm;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class SecurityController {
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    /*@GetMapping("/login")
    public String login(Model model){
        LoginForm loginForm = new LoginForm();
        model.addAttribute("login", loginForm);
        return "login-form";
    }*/

    @GetMapping("/login")
    public String login(){
        if (isAuthenticated()) {
            return "redirect:WelcomeHome";
        }
        return "dream-login";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

    @GetMapping(value = {"/","/WelcomeHome"})
    public String home(){
        return "WelcomeHome";
    }

    @GetMapping("/leaders") public String showLeaders(){
        return "leaders-form";
    }
}
