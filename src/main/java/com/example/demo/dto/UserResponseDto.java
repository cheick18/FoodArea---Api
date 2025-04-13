package com.example.demo.dto;

import com.example.demo.model.AccountType;


public class UserResponseDto {
    private Long id;
    private String login;
    private AccountType accountType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public UserResponseDto(Long id, String login, AccountType accountType) {
        this.id = id;
        this.login = login;
        this.accountType = accountType;
    }
}
