package com.example.gameapi.controller;

import com.example.gameapi.dto.EmailDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.LoginDto;
import com.example.gameapi.dto.MessageDto;
import com.example.gameapi.dto.RegisterDto;
import com.example.gameapi.dto.TokenDto;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Endpoint.AUTH)
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/register")
  public IdDto register(
      @Valid @RequestBody RegisterDto registerDto
  ) {
    return authService.register(registerDto);
  }

  @PostMapping("/login")
  public TokenDto login(
      @Valid @RequestBody LoginDto loginDto
  ) {
    return authService.login(loginDto);
  }

  @PostMapping("/renew")
  public TokenDto renewAuth(
      @RequestBody TokenDto expiredTokenDto
  ) {
    return authService.renewAuth(expiredTokenDto);
  }

  @PostMapping("/reset")
  public MessageDto resetAuth(
      @Valid @RequestBody EmailDto emailDto
  ) {
    return authService.resetPassword(emailDto);
  }
}
