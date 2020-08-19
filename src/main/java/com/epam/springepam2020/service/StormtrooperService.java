package com.epam.springepam2020.service;

import com.epam.springepam2020.model.Stormtrooper;

import java.util.List;

public interface StormtrooperService {

    List<Stormtrooper> getAll();

    Stormtrooper getById(Integer id);

    void deleteById(Integer id);

    Stormtrooper editById(Integer id, Stormtrooper stormtrooperToUpdate);

    Stormtrooper create(Stormtrooper stormtrooper);

    Stormtrooper getStormtrooperByFilters(Byte age);

}
