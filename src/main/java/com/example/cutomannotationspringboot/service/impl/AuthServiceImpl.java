package com.example.cutomannotationspringboot.service.impl;

import com.example.cutomannotationspringboot.dto.user.LoginResponseDto;
import com.example.cutomannotationspringboot.dto.user.LoginUserDto;
import com.example.cutomannotationspringboot.service.AuthService;
import com.example.cutomannotationspringboot.springsecurity.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public LoginResponseDto login(LoginUserDto loginUserDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getUsername(), loginUserDto.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtUtils.generateToken(loginUserDto.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}
