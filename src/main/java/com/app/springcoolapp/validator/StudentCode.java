package com.app.springcoolapp.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StudentCodeConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentCode {

    public String value() default "STD-";

    public String message() default "must start with STD-";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
