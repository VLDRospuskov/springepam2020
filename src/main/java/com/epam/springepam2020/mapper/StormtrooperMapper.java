package com.epam.springepam2020.mapper;

import com.epam.springepam2020.dto.response.StormtrooperResponseDto;
import com.epam.springepam2020.model.Stormtrooper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StormtrooperMapper {

    private final ModelMapper modelMapper;

    public StormtrooperResponseDto convertToDto(Stormtrooper stormtrooper) {
        StormtrooperResponseDto mappedStormtrooper =
                modelMapper.map(stormtrooper, StormtrooperResponseDto.class);
        String planet = stormtrooper.getAddresses().get(0).getPlanet();
        String street = stormtrooper.getAddresses().get(0).getStreet();
        Integer homeNumber = stormtrooper.getAddresses().get(0).getHomeNumber();
        mappedStormtrooper.setFullAddress(planet + " " + street + " " + homeNumber);
        return mappedStormtrooper;
    }
}

