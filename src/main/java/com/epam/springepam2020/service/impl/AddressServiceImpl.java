package com.epam.springepam2020.service.impl;

import com.epam.springepam2020.model.Address;
import com.epam.springepam2020.repository.AddressRepository;
import com.epam.springepam2020.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> getAddressesByStormtrooperId(Integer id) {
        return addressRepository.findByStormtrooperId(id);
    }

}
