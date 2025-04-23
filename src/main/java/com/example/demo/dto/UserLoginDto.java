package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class UserLoginDto {
    @NotNull(message = "Login can't be null")
    private String login;
    @NotNull(message = "Password can't be null")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLoginDto(@NotNull(message = "Login can't be null") String login, @NotNull(message = "Password can't be null") String password) {
        this.login = login;
        this.password = password;
    }

    public UserLoginDto() {
    }
}
