package com.epam.springepam2020.controller;

import com.epam.springepam2020.dto.AddressDto;
import com.epam.springepam2020.model.Address;
import com.epam.springepam2020.service.AddressService;
import com.epam.springepam2020.util.ObjectConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.epam.springepam2020.constants.ApiConstants.ADDRESS_PATH;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final ObjectConverter converter;
    private final AddressService addressService;

    @GetMapping(ADDRESS_PATH + "/{id}")
    public List<AddressDto> getAllAddressesByStormtrooperId(@PathVariable("id") Integer id) {
        List<Address> addressesByStormtrooperId = addressService.getAddressesByStormtrooperId(id);
        return converter.convertToList(addressesByStormtrooperId, AddressDto.class);
    }

}
