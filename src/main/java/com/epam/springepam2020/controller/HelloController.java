package com.epam.springepam2020.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // @RestController
//@RequestMapping("/api")
public class HelloController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello") // @RequestMapping
    public String getHello(Model model) {
        model.addAttribute("hello", "helloString");
        return "index";
    }

}
