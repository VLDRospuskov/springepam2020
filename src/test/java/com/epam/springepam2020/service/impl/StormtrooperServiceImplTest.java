package com.epam.springepam2020.service.impl;

import com.epam.springepam2020.exception.StormtrooperNotFoundException;
import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.repository.StormtrooperRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static com.epam.springepam2020.util.EntityGenerator.generateStormtrooper;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StormtrooperServiceImplTest {

    @Mock
    private StormtrooperRepository stormtrooperRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private StormtrooperServiceImpl stormtrooperService;

    @Mock
    private Stormtrooper stormtrooper;

    @Spy
    private Stormtrooper stormtrooper2;


    @Test
    public void getById() {
        when(stormtrooperRepository.findById(any(Integer.class))).thenReturn(Optional.of(stormtrooper));

        Stormtrooper actualStormtrooper = stormtrooperService.getById(any(Integer.class));

        assertEquals(stormtrooper, actualStormtrooper);
    }

    @Test(expected = StormtrooperNotFoundException.class)
    public void getByIdNotFound() {
        when(stormtrooperRepository.findById(any(Integer.class))).thenReturn(Optional.empty());

        Stormtrooper actualStormtrooper = stormtrooperService.getById(any(Integer.class));

        assertEquals(stormtrooper, actualStormtrooper);
    }

    @Test
    public void createStormtrooper() {
        Stormtrooper stormtrooper = generateStormtrooper();

        when(stormtrooperRepository.save(any(Stormtrooper.class))).thenReturn(stormtrooper);
        Stormtrooper createdStormtrooper = stormtrooperService.create(stormtrooper);

        verify(stormtrooperRepository, times(1)).save(stormtrooper);
        assertEquals(stormtrooper, createdStormtrooper);
    }

    @Test
    public void updateLogin() {
        Stormtrooper stormtrooperToUpdate = generateStormtrooper();
        stormtrooperToUpdate.setLogin("Login2");

        when(stormtrooperRepository.findById(anyInt())).thenReturn(Optional.of(stormtrooper2));

        Stormtrooper updatedStormtrooper = stormtrooperService.editById(anyInt(), stormtrooperToUpdate);

        assertEquals("Login2", updatedStormtrooper.getLogin());
    }

}
