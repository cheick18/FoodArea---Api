package com.example.demo.dto;

import com.example.demo.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTo {
    private String login;
    private String password;
    private AccountType accountType;
}
