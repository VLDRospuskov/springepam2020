package com.epam.springepam2020.service;

import com.epam.springepam2020.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAddressesByStormtrooperId(Integer id);

}
