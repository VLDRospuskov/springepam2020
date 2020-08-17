package com.epam.springepam2020.service.impl;

import com.epam.springepam2020.dao.StormtrooperDao;
import com.epam.springepam2020.exception.StormtrooperException;
import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.repository.StormtrooperRepository;
import com.epam.springepam2020.service.StormtrooperService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StormtrooperServiceImpl implements StormtrooperService {

    private StormtrooperDao stormtrooperDao;
    private StormtrooperRepository stormtrooperRepository;

    public StormtrooperServiceImpl(StormtrooperDao stormtrooperDao, StormtrooperRepository stormtrooperRepository) {
        this.stormtrooperDao = stormtrooperDao;
        this.stormtrooperRepository = stormtrooperRepository;
    }

    @Override
    public List<Stormtrooper> getAll() {
        return stormtrooperDao.getAll();
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
        stormtrooperDao.deleteById(id);
    }

    @Override
    public void save(Stormtrooper stormtrooper) {
        if (checkIfStormtrooperNameIsExist(stormtrooper)) {
            throw new StormtrooperException("Stormtrooper with that name is already exist");
        } else {
            stormtrooperDao.save(stormtrooper);
        }
    }

    @Override
    public Stormtrooper getStormtrooperByAge(Byte age) {
        return stormtrooperRepository.findByAge(age);
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
