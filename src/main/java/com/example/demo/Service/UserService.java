package com.example.demo.Service;

import com.example.demo.dto.UserDTo;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserResponseDto createUser(UserDTo userDTo){
        User user= UserMapper.INSTANCE.toEntity(userDTo);

        return UserMapper.INSTANCE.toResponseDto(userRepository.save(user));
    }
    public UserResponseDto getUserById(Long id){
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        return UserMapper.INSTANCE.toResponseDto(user);

    }
    @Transactional
    public void deleteUser(Long id){
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        userRepository.deleteById(id);

    }
    @Transactional
    public UserResponseDto updateUser(Long id,UserDTo userDTo){
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        User updatedUser=UserMapper.INSTANCE.toEntity(userDTo);
        user.setComments(updatedUser.getComments());
        user.setAccountType(user.getAccountType());
        user.setRecipes(updatedUser.getRecipes());
        user.setLogin(updatedUser.getLogin());
        user.setPassword(user.getPassword());
       return UserMapper.INSTANCE.toResponseDto(userRepository.save(user));

    }
    public Set<UserResponseDto> getAllUser(){
        Set<User> users= (Set<User>) userRepository.findAll();
        return UserMapper.INSTANCE.toResponseDtoSet(users);

    }
}
