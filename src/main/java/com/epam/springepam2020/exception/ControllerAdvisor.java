package com.epam.springepam2020.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(RuntimeException.class)
    public String handle(Exception exception, Model model) {
        model.addAttribute("exception", exception.getMessage());
        return "errorPage";
    }
}
