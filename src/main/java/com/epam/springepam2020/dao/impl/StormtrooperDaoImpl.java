package com.epam.springepam2020.dao.impl;

import com.epam.springepam2020.dao.StormtrooperDao;
import com.epam.springepam2020.model.Stormtrooper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StormtrooperDaoImpl implements StormtrooperDao {

    private static int identifier = 1;
    private static List<Stormtrooper> stormtroopers = new ArrayList<>();


    @Override
    public List<Stormtrooper> getAll() {
        return stormtroopers;
    }

    @Override
    public Stormtrooper getNewStormtrooper() {
        Stormtrooper stormtrooper = new Stormtrooper();
        stormtrooper.setId(identifier++);
        return stormtrooper;
    }
}
