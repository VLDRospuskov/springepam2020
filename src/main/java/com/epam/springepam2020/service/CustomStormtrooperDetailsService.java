package com.epam.springepam2020.service;

import com.epam.springepam2020.model.security.CustomStormtrooperDetails;

public interface CustomStormtrooperDetailsService {

    CustomStormtrooperDetails loadStormtrooperByLogin(String login);

}
