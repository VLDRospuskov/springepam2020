package com.epam.springepam2020.dao;

import com.epam.springepam2020.model.Stormtrooper;

import java.util.List;

public interface StormtrooperDao {

    List<Stormtrooper> getAll();

    void save(Stormtrooper stormtrooper);

    void deleteById(Integer id);
}
