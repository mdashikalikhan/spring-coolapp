package com.app.springcoolapp.res;

import com.app.springcoolapp.model.StudentForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${districts}")
    private List<String> districts;
    @GetMapping("/studentRegistration")
    public String showForm(Model model){
        StudentForm studentForm = new StudentForm();
        model.addAttribute("student", studentForm);
        model.addAttribute("districts", districts);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") StudentForm studentForm){
        return "student-confirmation";
    }
}
