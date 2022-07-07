package com.example.gameapi.service;

import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.LoginDto;
import com.example.gameapi.dto.RegisterDto;
import com.example.gameapi.dto.TokenDto;

public interface AuthService {
  IdDto register(RegisterDto registerDto);

  TokenDto login(LoginDto loginDto);
}
