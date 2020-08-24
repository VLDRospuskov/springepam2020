package com.epam.springepam2020.service;

import com.epam.springepam2020.model.Stormtrooper;

import java.util.List;

public interface StormtrooperService {

    List<Stormtrooper> getAll();

    Stormtrooper getById(Integer id);

    Stormtrooper getByLogin(String login);

    Stormtrooper getByLoginAndPassword(String login, String password);

    void deleteById(Integer id);

    Stormtrooper editById(Integer id, Stormtrooper stormtrooperToUpdate);

    Stormtrooper create(Stormtrooper stormtrooper);

    Stormtrooper getStormtrooperByFilters(Byte age);

}
