package com.epam.springepam2020.service;

import com.epam.springepam2020.model.Stormtrooper;

import java.util.List;

public interface StormtrooperService {

    List<Stormtrooper> getAll();

    void deleteById(Integer id);

    Stormtrooper updateById(Integer id);

    void save(Stormtrooper stormtrooper);

    Stormtrooper getStormtrooperByAge(Byte age);

}
