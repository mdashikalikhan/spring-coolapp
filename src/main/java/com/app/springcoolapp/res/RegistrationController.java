package com.app.springcoolapp.res;

import com.app.springcoolapp.entity.CustomUser;
import com.app.springcoolapp.model.RegistrationForm;
import com.app.springcoolapp.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegistrationController {
    private  UserService userService;

    private Logger logger = Logger.getLogger(getClass().getName());


    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("registrationForm", new RegistrationForm());
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm,
            BindingResult theBindingResult,
            HttpSession session, Model theModel) {
        String userName = registrationForm.getUserName();
        logger.info("Processing registration form for: " + userName);
// form validation
        if (theBindingResult.hasErrors()){
            return "registration-form";
        }
// check the database if user already exists
        CustomUser existing = userService.findByUserName(userName);
        if (existing != null){
            theModel.addAttribute("registrationForm", new RegistrationForm());
            theModel.addAttribute("registrationError", "User name already exists.");
            logger.warning("User name already exists.");
            return "registration-form";
        }
        // create user account and store in the databse
        userService.save(registrationForm);

        logger.info("Successfully created user: " + userName);
        // place user in the web http session for later use
        session.setAttribute("user", registrationForm);
        return "registration-confirmation";
    }

    @GetMapping("/international") public void international(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {
        String lang = request.getParameter("lang");
        if(lang==null){
            log.info("language is null");
        } else if(lang.equals("en")){
            log.info("language is english");
        } else if(lang.equals("bn")){
            log.info("language is bangla");
        }
        request.getRequestDispatcher("/login").forward(request, response);
    }

}
