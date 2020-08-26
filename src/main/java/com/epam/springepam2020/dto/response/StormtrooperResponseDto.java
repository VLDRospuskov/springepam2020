package com.epam.springepam2020.dto.response;

import com.epam.springepam2020.dto.AddressDto;
import com.epam.springepam2020.dto.WeaponDto;
import com.epam.springepam2020.model.Address;
import com.epam.springepam2020.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StormtrooperResponseDto {

    private String login;

    private Integer age;

    private Role role;

    private WeaponDto weapon;

    private List<AddressDto> addresses;

    private String fullAddress;

}
// dfgdfgdfgvncbv gdfgdfgdfgdf 20
// 3 fields -> 1 fields
// "planet": "dfgdfgdfgvncbv",
//         "street": "gdfgdfgdfgdf",
//         "homeNumber": 20
