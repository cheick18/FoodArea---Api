package com.example.demo.Service;

import com.example.demo.dto.UserDTo;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.AppUser;
import com.example.demo.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }
    public UserResponseDto toResponseDto(AppUser user)
    {
        return new UserResponseDto(user.getId(), user.getLogin(), user.getAccountType());

    }
    public UserResponseDto createUser(UserDTo userDTo)
    {
        AppUser user=new AppUser();
        user.setPassword(bCryptPasswordEncoder.encode(userDTo.getPassword()));
        user.setAccountType(userDTo.getAccountType());
        user.setLogin(userDTo.getLogin());
        return toResponseDto(userRepository.save(user));
    }


    public boolean verifyUser(UserDTo userDTo){
    Authentication authentication =
                            authenticationManager.authenticate(
                             new UsernamePasswordAuthenticationToken(userDTo.getLogin(),userDTo.getPassword())
                             );
     /*   var user=userRepository.findByLogin(userDTo.getLogin());

      */
        if(authentication.isAuthenticated())
            return true;
        return false;

    }
    public UserResponseDto getUserById(Long id)
    {
        AppUser user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        return toResponseDto(user);

    }
    @Transactional
    public void deleteUser(Long id)
    {
        AppUser user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        userRepository.deleteById(id);

    }
    @Transactional
    public UserResponseDto updateUser(Long id,UserDTo userDTo)
    {
        AppUser user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        user.setAccountType(userDTo.getAccountType());
        user.setLogin(userDTo.getLogin());
        user.setPassword(userDTo.getPassword());
       return toResponseDto(userRepository.save(user));

    }
    public Set<UserResponseDto> getAllUser()
    {
        List<AppUser> users=  userRepository.findAll();
        List<UserResponseDto> usersdto=users.stream().map(this::toResponseDto).toList();
        Set<UserResponseDto> usersSet= new HashSet<>(usersdto);
        return usersSet;

    }
}
