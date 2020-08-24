package com.epam.springepam2020.service.impl;

import com.epam.springepam2020.exception.StormtrooperNotFoundException;
import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.repository.StormtrooperRepository;
import com.epam.springepam2020.service.StormtrooperService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.springepam2020.exception.StormtrooperNotFoundException.stormtrooperNotFoundExceptionById;
import static com.epam.springepam2020.model.Role.ROLE_PRIVATE;

@Service
@Transactional
@RequiredArgsConstructor
public class StormtrooperServiceImpl implements StormtrooperService {

    private final StormtrooperRepository stormtrooperRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Stormtrooper> getAll() {
        return stormtrooperRepository.findAll();
    }

    @Override
    public Stormtrooper getById(Integer id) {
        return stormtrooperRepository.findById(id).orElseThrow(stormtrooperNotFoundExceptionById(id));
    }

    @Override
    public Stormtrooper getByLogin(String login) {
        return stormtrooperRepository.findByLogin(login);
    }

    @Override
    public Stormtrooper getByLoginAndPassword(String login, String password) {
        Stormtrooper stormtrooper = getByLogin(login);
        if (stormtrooper != null) {
            if (passwordEncoder.matches(password, stormtrooper.getPassword())) {
                return stormtrooper;
            }
        }
        throw new StormtrooperNotFoundException("Stromtrooper not found");
    }

    @Override
    public Stormtrooper create(Stormtrooper stormtrooper) {
        if (checkIfStormtrooperNameIsExist(stormtrooper)) {
            throw new StormtrooperNotFoundException("Stormtrooper with that login is already exist");
        } else {
            stormtrooper.setRole(ROLE_PRIVATE);
            stormtrooper.setPassword(passwordEncoder.encode(stormtrooper.getPassword()));
            return stormtrooperRepository.save(stormtrooper);
        }
    }

    @Override
    public void deleteById(Integer id) {
        stormtrooperRepository.deleteById(id);
    }

    @Override
    public Stormtrooper editById(Integer id, Stormtrooper stormtrooperToUpdate) {
        Stormtrooper stormtrooper = getById(id);
        if (stormtrooperToUpdate.getLogin() != null) {
            stormtrooper.setLogin(stormtrooperToUpdate.getLogin());
        }
        if (stormtrooperToUpdate.getAge() != null) {
            stormtrooper.setAge(stormtrooperToUpdate.getAge());
        }
        if (stormtrooperToUpdate.getWeapon() != null) {
            stormtrooper.setWeapon(stormtrooperToUpdate.getWeapon());
        }

        return stormtrooper;
    }

    @Override
    public Stormtrooper getStormtrooperByFilters(Byte age) {
        return stormtrooperRepository.findByAge(age);
    }

    private boolean checkIfStormtrooperNameIsExist(Stormtrooper stormtrooper) {
        List<Stormtrooper> stormtroopers = getAll().stream()
                .filter(stormtrooperDB -> stormtrooperDB.getLogin().equals(stormtrooper.getLogin()))
                .collect(Collectors.toList());
        if (!stormtroopers.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
