package com.epam.springepam2020.model.security;

import com.epam.springepam2020.model.Stormtrooper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomStormtrooperDetails implements UserDetails {

    private String login;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static CustomStormtrooperDetails fromStormtrooperToCustomUserDetails(Stormtrooper stormtrooper) {
        CustomStormtrooperDetails customStormtrooperDetails = new CustomStormtrooperDetails();
        customStormtrooperDetails.login = stormtrooper.getLogin();
        customStormtrooperDetails.password = stormtrooper.getPassword();
        customStormtrooperDetails.grantedAuthorities =
                Collections.singletonList(new SimpleGrantedAuthority(stormtrooper.getRole().name()));
        return customStormtrooperDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
