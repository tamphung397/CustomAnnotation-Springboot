package com.example.cutomannotationspringboot.controller;

import com.example.cutomannotationspringboot.dto.user.LoginResponseDto;
import com.example.cutomannotationspringboot.dto.user.LoginUserDto;
import com.example.cutomannotationspringboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginUserDto loginUserDto){
       LoginResponseDto loginResponseDto = authService.login(loginUserDto);
       return ResponseEntity.ok(loginResponseDto);
    }
}
