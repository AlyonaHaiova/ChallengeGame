package com.example.gameapi.controller;

import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RegisterDto;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoint.AUTH)
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/register")
  public IdDto register(
      @RequestBody RegisterDto registerDto
  ) {
    return authService.register(registerDto);
  }
}
