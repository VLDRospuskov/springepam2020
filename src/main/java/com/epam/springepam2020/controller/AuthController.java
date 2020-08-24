package com.epam.springepam2020.controller;

import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.model.security.AuthResponse;
import com.epam.springepam2020.model.security.RegistrationRequest;
import com.epam.springepam2020.service.StormtrooperService;
import com.epam.springepam2020.util.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private StormtrooperService stormtrooperService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerStomrtrooper(@RequestBody RegistrationRequest registrationRequest) {
        Stormtrooper stormtrooper = new Stormtrooper();
        stormtrooper.setLogin(registrationRequest.getLogin());
        stormtrooper.setPassword(registrationRequest.getPassword());
        stormtrooperService.create(stormtrooper);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody RegistrationRequest authRequest) {
        Stormtrooper stormtrooper =
                stormtrooperService.getByLoginAndPassword(authRequest.getLogin(), authRequest.getPassword());
        String token = jwtProvider.generateToken(stormtrooper.getLogin());
        return new AuthResponse(token);
    }
}