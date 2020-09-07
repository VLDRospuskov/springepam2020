package com.epam.springepam2020.dto;

import com.epam.springepam2020.dto.response.StormtrooperResponseDto;
import com.epam.springepam2020.validation.PasswordValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StormtrooperDto extends StormtrooperResponseDto {

    @PasswordValidation
    private String password;

}
