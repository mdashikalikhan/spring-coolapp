package com.app.springcoolapp.res;

import com.app.springcoolapp.model.StudentForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${districts}")
    private List<String> districts;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> operatingSystems;

    @GetMapping("/studentRegistration")
    public String showForm(Model model){
        StudentForm studentForm = new StudentForm();
        studentForm.setDistricts(districts);
        studentForm.setLanguages(languages);
        studentForm.setOperatingSystems(operatingSystems);
        model.addAttribute("student", studentForm);
        /*model.addAttribute("districts", districts);
        model.addAttribute("languages", languages);
        model.addAttribute("operatingSystems", operatingSystems);*/
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@Valid @ModelAttribute("student") StudentForm studentForm,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            studentForm.setDistricts(districts);
            studentForm.setLanguages(languages);
            studentForm.setOperatingSystems(operatingSystems);
            return "student-form";
        }
        return "student-confirmation";
    }
}
