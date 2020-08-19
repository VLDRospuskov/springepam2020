package com.epam.springepam2020.controller;

import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.service.StormtrooperService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.epam.springepam2020.constants.ApiConstants.STORMTROOPER_PATH;

@RestController
@RequiredArgsConstructor
public class StormtrooperController {

    private final StormtrooperService stormtrooperService;

    @GetMapping("/admin/get")
    public String getAdmin() {
        return "Hi admin";
    }

    @GetMapping("/user/get")
    public String getUser() {
        return "Hi user";
    }

    @GetMapping(STORMTROOPER_PATH)
    public List<Stormtrooper> getAllStormtroopers() {
        return stormtrooperService.getAll();
    }

    @PostMapping(STORMTROOPER_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create stormtrooper")
    public Stormtrooper createStormtrooper(@RequestBody Stormtrooper stormtrooper) {
        return stormtrooperService.create(stormtrooper);
    }

    @DeleteMapping(STORMTROOPER_PATH + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStormtrooper(@PathVariable("id") Integer id) {
        stormtrooperService.deleteById(id);
    }

    @PatchMapping(STORMTROOPER_PATH + "/{id}")
    public Stormtrooper editStormtrooper(
            @PathVariable("id") Integer id, @RequestBody Stormtrooper stormtrooperToUpdate
    ) {
        return stormtrooperService.editById(id, stormtrooperToUpdate);
    }

    @PostMapping("/filter")
    public Stormtrooper stormtrooperFilter(@RequestParam("age") Byte age) {
        return stormtrooperService.getStormtrooperByFilters(age);
    }

}
