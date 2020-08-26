package com.epam.springepam2020.repository;

import com.epam.springepam2020.model.Address;
import com.epam.springepam2020.model.Stormtrooper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByStormtrooperId(Integer id);
}
