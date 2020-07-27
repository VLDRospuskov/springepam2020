package com.epam.springepam2020.service.impl;

import com.epam.springepam2020.dao.StormtrooperDao;
import com.epam.springepam2020.exception.StormtrooperException;
import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.service.StormtrooperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StormtrooperServiceImpl implements StormtrooperService {

    private final StormtrooperDao stormtrooperDao;


    @Override
    public List<Stormtrooper> getAll() {
        return stormtrooperDao.getAll();
    }

    @Override
    public Stormtrooper getNewStormtrooper() {
        return stormtrooperDao.getNewStormtrooper();
    }

    @Override
    public Stormtrooper updateById(Integer id) {
        Stormtrooper stormtrooperToUpdate = getAll().stream()
                .filter(stormtrooper -> stormtrooper.getId().equals(id))
                .findFirst()
                .orElse(null);
        getAll().remove(stormtrooperToUpdate);
        return stormtrooperToUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        getAll().removeIf(stormtrooper -> stormtrooper.getId().equals(id));
    }

    @Override
    public void save(Stormtrooper stormtrooper) {
        if (checkIfStormtrooperNameIsExist(stormtrooper)) {
            throw new StormtrooperException("Stormtrooper with that name is already exist");
        } else {
            getAll().add(stormtrooper);
        }
    }

    private boolean checkIfStormtrooperNameIsExist(Stormtrooper stormtrooper) {
        List<Stormtrooper> stormtroopers = getAll().stream()
                .filter(stormtrooperDB -> stormtrooperDB.getName().equals(stormtrooper.getName()))
                .collect(Collectors.toList());
        if (!stormtroopers.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
