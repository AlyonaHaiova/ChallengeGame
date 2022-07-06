package com.example.gameapi.service;

import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RegisterDto;

public interface AuthService {
  IdDto register(RegisterDto registerDto);
}
