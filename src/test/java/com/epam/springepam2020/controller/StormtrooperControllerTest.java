package com.epam.springepam2020.controller;

import com.epam.springepam2020.Application;
import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.service.StormtrooperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.epam.springepam2020.constants.ApiConstants.STORMTROOPER_PATH;
import static com.epam.springepam2020.util.EntityGenerator.generateStormtrooper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
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

}
