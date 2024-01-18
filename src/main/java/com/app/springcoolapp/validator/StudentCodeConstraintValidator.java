package com.app.springcoolapp.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StudentCodeConstraintValidator implements ConstraintValidator<StudentCode, String> {

    private String prefix;
    @Override
    public void initialize(StudentCode constraintAnnotation) {
        this.prefix
                 = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null){
            return true;
        }
        return value.startsWith(prefix);
    }
}
