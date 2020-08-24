package com.epam.springepam2020.service.impl;

import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.model.security.CustomStormtrooperDetails;
import com.epam.springepam2020.service.CustomStormtrooperDetailsService;
import com.epam.springepam2020.service.StormtrooperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomStormtrooperDetailsServiceImpl implements CustomStormtrooperDetailsService {

    private final StormtrooperService stormtrooperService;

    @Override
    public CustomStormtrooperDetails loadStormtrooperByLogin(String login) {
        Stormtrooper stormtrooper = stormtrooperService.getByLogin(login);
        return CustomStormtrooperDetails.fromStormtrooperToCustomUserDetails(stormtrooper);
    }
}
