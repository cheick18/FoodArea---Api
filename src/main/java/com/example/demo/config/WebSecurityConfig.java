package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf->csrf.disable()).authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers(HttpMethod.GET, "/api/categories","/api/categories/{id}", "/api/recipes","/api/recipes/{id}","/api/comments","/api/auth/registration").permitAll()
                        .requestMatchers(HttpMethod.POST,  "/api/auth/login","/api/auth/registration").permitAll()
                        .anyRequest().authenticated()
        )
                .httpBasic(Customizer.withDefaults());




       return  httpSecurity.build();

    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails wague= User.withUsername("wague")
                .password("{noop}1111")
                .roles("USER")
                .build();
        UserDetails cheickne= User.withUsername("cheickne")
                .password("{noop}1111")
                .roles("USER")
                .build();
       return new InMemoryUserDetailsManager(wague,cheickne);

    }
}
