package com.epam.springepam2020.controller;

import com.epam.springepam2020.Application;
import com.epam.springepam2020.dto.StormtrooperDto;
import com.epam.springepam2020.dto.response.StormtrooperResponseDto;
import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.service.StormtrooperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.epam.springepam2020.constants.ApiConstants.STORMTROOPER_PATH;
import static com.epam.springepam2020.util.EntityGenerator.generateStormtrooper;
import static com.epam.springepam2020.util.EntityGenerator.generateStormtrooperDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("test")
public class StormtrooperControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StormtrooperService stormtrooperService;

    @Test
    public void getAllStormtroopers() {
        stormtrooperService.create(generateStormtrooper());
        stormtrooperService.create(generateStormtrooper());

        ResponseEntity<List<Stormtrooper>> response = restTemplate.exchange(
                STORMTROOPER_PATH,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Stormtrooper>>() {
                }
        );

        assertEquals(OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void createStormtrooper() {
        StormtrooperDto stormtrooperDto = generateStormtrooperDto();

        ResponseEntity<StormtrooperResponseDto> response = restTemplate.exchange(
                STORMTROOPER_PATH,
                HttpMethod.POST,
                new HttpEntity<>(stormtrooperDto),
                StormtrooperResponseDto.class
        );

        assertEquals(CREATED, response.getStatusCode());
    }

    @Test
    public void getStormtrooperByFilter() {
        Stormtrooper stormtrooper = generateStormtrooper();
        stormtrooperService.create(stormtrooper);

        Stormtrooper stormtrooperSecond = generateStormtrooper();
        stormtrooperSecond.setAge((byte) 20);
        stormtrooperService.create(stormtrooperSecond);

        ResponseEntity<Stormtrooper> response = restTemplate.exchange(
                "/filter?age=" + 10,
                HttpMethod.POST,
                null,
                Stormtrooper.class
        );

        assertEquals(OK, response.getStatusCode());
        assertEquals(10, response.getBody().getAge().byteValue());
    }

}
