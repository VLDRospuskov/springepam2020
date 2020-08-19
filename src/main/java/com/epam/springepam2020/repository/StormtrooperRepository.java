package com.epam.springepam2020.repository;

import com.epam.springepam2020.model.Stormtrooper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StormtrooperRepository extends JpaRepository<Stormtrooper, Integer> {

    Stormtrooper findByAge(Byte age);

    Stormtrooper findByLogin(String login);

}
