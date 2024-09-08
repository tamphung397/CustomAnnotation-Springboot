package com.example.cutomannotationspringboot.service;

import com.example.cutomannotationspringboot.dto.user.LoginResponseDto;
import com.example.cutomannotationspringboot.dto.user.LoginUserDto;

public interface AuthService {
    LoginResponseDto login(LoginUserDto loginUserDto);
}
