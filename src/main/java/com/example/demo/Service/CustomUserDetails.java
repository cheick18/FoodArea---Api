package com.example.demo.Service;

import com.example.demo.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    private final AppUser appUser;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role= String.valueOf(appUser.getAccountType());
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getLogin();
    }

    public CustomUserDetails(AppUser appUser) {
        this.appUser = appUser;
    }

}
