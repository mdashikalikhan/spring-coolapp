package com.app.springcoolapp.res;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @RequestMapping("/inputForm")
    public String showInitialForm(){
        return "my-first-form";
    }

    @RequestMapping("/inputFormError")
    public String showInitialFormWithError(Model model){
        return "my-first-form";
    }
    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request, Model model){
        String name = request.getParameter("studentName");
        if(name==null || name.trim().isEmpty()){
            model.addAttribute("error", "Student name must not be empty..");
            return showInitialFormWithError(model);
        }
        String message = "Welcome " + name.toUpperCase();
        model.addAttribute("message", message);
        return "MVCWelcome";
    }

    @RequestMapping("/processFormVersion2")
    public String processFormv2(@RequestParam("studentName")String name, Model model){
        if(name==null || name.trim().isEmpty()){
            model.addAttribute("error", "Student name must not be empty..");
            return showInitialFormWithError(model);
        }
        String message = "Welcome " + name.toUpperCase();
        model.addAttribute("message", message);
        return "MVCWelcome";
    }
}
