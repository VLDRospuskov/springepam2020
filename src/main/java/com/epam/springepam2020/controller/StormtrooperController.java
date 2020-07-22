package com.epam.springepam2020.controller;

import com.epam.springepam2020.model.Stormtrooper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StormtrooperController {

    List<Stormtrooper> stormtroopers = new ArrayList<>();

    // GetAll
    @GetMapping("/listStormtroopers")
    public String getAllStormtroopers(Model model) {
        model.addAttribute("listStormtroopers", stormtroopers);
        return "listStormtroopers";
    }

    // Add
    @GetMapping("/addStormtrooper")
    public String getFormStormtrooper(Stormtrooper stormtrooper) {
        return "addStormtrooper";
    }

    @PostMapping("/addStormtrooper")
    public String addStormtrooper(Stormtrooper stormtrooper) {
        List<Stormtrooper> stormtroopers = generateStormtroopers();
        stormtroopers.add(stormtrooper);
        return "redirect:/listStormtroopers";
    }

    private List<Stormtrooper> generateStormtroopers() {
        stormtroopers.add(new Stormtrooper("stormtrooper1", "blaster"));
        stormtroopers.add(new Stormtrooper("stormtrooper2", "blaste2"));
        stormtroopers.add(new Stormtrooper("stormtrooper3", "blaster3"));
        return stormtroopers;
    }
}
