package com.example.demo.Service;

import com.example.demo.dto.UserDTo;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserResponseDto toResponseDto(User user){
        return new UserResponseDto(user.getId(), user.getLogin(), user.getAccountType());

    }
    public UserResponseDto createUser(UserDTo userDTo){
        User user=new User();
        user.setPassword(userDTo.getPassword());
        user.setAccountType(userDTo.getAccountType());
        user.setLogin(userDTo.getLogin());
        return toResponseDto(userRepository.save(user));
    }

    public UserResponseDto getUserById(Long id){
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        return toResponseDto(user);

    }
    @Transactional
    public void deleteUser(Long id){
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        userRepository.deleteById(id);

    }
    @Transactional
    public UserResponseDto updateUser(Long id,UserDTo userDTo){
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        user.setAccountType(userDTo.getAccountType());
        user.setLogin(userDTo.getLogin());
        user.setPassword(userDTo.getPassword());
       return toResponseDto(userRepository.save(user));

    }
    public Set<UserResponseDto> getAllUser(){
        List<User> users=  userRepository.findAll();
        List<UserResponseDto> usersdto=users.stream().map(this::toResponseDto).toList();
        Set<UserResponseDto> usersSet= new HashSet<>(usersdto);
        return usersSet;

    }
}
