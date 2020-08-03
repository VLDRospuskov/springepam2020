package com.epam.springepam2020.controller;

import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.service.StormtrooperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StormtrooperController {

    @Autowired
    private StormtrooperService stormtrooperService;

    // GetAll
    @GetMapping("/")
    public String getAllStormtroopers(Model model) {
        List<Stormtrooper> stormtroopers = stormtrooperService.getAll();
        model.addAttribute("listStormtroopers", stormtroopers);
        return "listStormtroopers";
    }

    // Add
    @GetMapping("/addStormtrooper")
    public String getFormStormtrooper(Model model) {
        model.addAttribute("stormtrooper", new Stormtrooper());
        return "addStormtrooper";
    }

    @PostMapping("/save")
    public String addStormtrooper(Stormtrooper stormtrooper, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addStormtrooper";
        }
        stormtrooperService.save(stormtrooper);
        return "redirect:/";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteStormtrooper(@PathVariable("id") Integer id) {
        stormtrooperService.deleteById(id);
        return "redirect:/";
    }

    // Update
    @GetMapping("/update/{id}")
    public String editStormtrooper(@PathVariable("id") Integer id, Model model) {
        Stormtrooper updatedStormtrooper = stormtrooperService.updateById(id);
        model.addAttribute("stormtrooper", updatedStormtrooper);
        return "updateStormtrooper";
    }

}
