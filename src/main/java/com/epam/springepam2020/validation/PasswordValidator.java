package com.epam.springepam2020.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password.length() > 5;
    }

    @Override
    public void initialize(PasswordValidation constraintAnnotation) {
        System.out.println("Hello");
    }
}
