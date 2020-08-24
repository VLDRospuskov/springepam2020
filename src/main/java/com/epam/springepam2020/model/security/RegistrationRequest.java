package com.epam.springepam2020.model.security;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String login;

    private String password;

}
