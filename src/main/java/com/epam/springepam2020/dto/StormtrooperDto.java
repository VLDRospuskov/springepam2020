package com.epam.springepam2020.dto;

import com.epam.springepam2020.dto.response.StormtrooperResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StormtrooperDto extends StormtrooperResponseDto {

    private String password;

}
