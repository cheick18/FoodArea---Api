package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTo;
import com.example.demo.dto.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("")
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserDTo userDTo){
        UserResponseDto savedUser=userService.createUser(userDTo);
        return ResponseEntity.ok(savedUser);

    }
    @GetMapping("/api/users/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id){
       return ResponseEntity.ok(userService.getUserById(id));

    }
    @GetMapping("/api/users")
    public ResponseEntity<Set<UserResponseDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());

    }
    @PutMapping("/api/users/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id,@Valid @RequestBody UserDTo userDto){
        return ResponseEntity.ok(userService.updateUser(id,userDto));

    }
    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
