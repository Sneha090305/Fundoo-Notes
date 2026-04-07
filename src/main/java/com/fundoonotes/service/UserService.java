package com.fundoonotes.service;

import com.fundoonotes.dto.request.LoginRequestDto;
import com.fundoonotes.dto.request.UserRegisterRequestDto;
import com.fundoonotes.dto.response.LoginResponseDto;

public interface UserService {

    String register(UserRegisterRequestDto dto);

    LoginResponseDto login(LoginRequestDto dto);
}