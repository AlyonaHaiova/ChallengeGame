package com.example.gameapi.controller;

import com.example.gameapi.dto.EmailDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.LoginDto;
import com.example.gameapi.dto.MessageDto;
import com.example.gameapi.dto.RegisterDto;
import com.example.gameapi.dto.TokenDto;
import com.example.gameapi.dto.UserDto;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.AuthService;
import com.example.gameapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(Endpoint.AUTH)
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;
  private final UserService userService;

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

  @GetMapping("/info/{email}")
  public UserDto getUserInfo(
      @PathVariable("email") String email
  ) {
    Optional<UserDto> user = userService.findUserByEmail(email);
    return user.orElseThrow(() -> new IllegalArgumentException("No user with email " + email));
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
