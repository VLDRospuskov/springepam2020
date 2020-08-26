package com.epam.springepam2020.controller;

import com.epam.springepam2020.dto.StormtrooperDto;
import com.epam.springepam2020.dto.response.StormtrooperResponseDto;
import com.epam.springepam2020.mapper.StormtrooperMapper;
import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.service.StormtrooperService;
import com.epam.springepam2020.util.ObjectConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final ObjectConverter converter;
    private final StormtrooperMapper stormtrooperMapper;

    @GetMapping(STORMTROOPER_PATH)
    public List<Stormtrooper> getAllStormtroopers() {
        return stormtrooperService.getAll();
    }

    @GetMapping(STORMTROOPER_PATH + "/{id}")
    public StormtrooperResponseDto getStromtrooperById(@PathVariable("id") Integer id) {
        Stormtrooper stormtrooper = stormtrooperService.getById(id);
        StormtrooperResponseDto stormtrooperResponseDto =
                stormtrooperMapper.convertToDto(stormtrooper);
        return stormtrooperResponseDto;
    }

    @PostMapping(STORMTROOPER_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create stormtrooper")
    public StormtrooperResponseDto createStormtrooper(@RequestBody StormtrooperDto stormtrooperDto) {
        Stormtrooper stormtrooper = converter.convert(stormtrooperDto, Stormtrooper.class);
        Stormtrooper createdStormtrooper = stormtrooperService.create(stormtrooper);
        return  converter.convert(createdStormtrooper, StormtrooperResponseDto.class);
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
