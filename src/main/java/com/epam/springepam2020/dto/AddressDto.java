package com.epam.springepam2020.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String planet;

    private String street;

    private Integer homeNumber;

}
