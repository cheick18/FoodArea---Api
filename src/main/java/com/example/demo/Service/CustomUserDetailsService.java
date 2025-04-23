package com.example.demo.Service;

import com.example.demo.model.AppUser;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<AppUser> appUser= userRepository.findByLogin(username);
        if(appUser.isEmpty()){
            throw new UsernameNotFoundException("user not found");
        }

        return new CustomUserDetails(appUser.get());
    }
}
