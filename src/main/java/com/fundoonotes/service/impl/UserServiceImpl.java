package com.fundoonotes.service.impl;

import com.fundoonotes.dto.request.LoginRequestDto;
import com.fundoonotes.dto.request.UserRegisterRequestDto;
import com.fundoonotes.dto.response.LoginResponseDto;
import com.fundoonotes.entity.User;
import com.fundoonotes.repository.UserRepository;
import com.fundoonotes.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Constructor Injection
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // REGISTER METHOD
    @Override
    public String register(UserRegisterRequestDto dto) {

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // LOGIN METHOD
    @Override
    public LoginResponseDto login(LoginRequestDto dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new LoginResponseDto("dummy-token", "Login Successful");
    }
}