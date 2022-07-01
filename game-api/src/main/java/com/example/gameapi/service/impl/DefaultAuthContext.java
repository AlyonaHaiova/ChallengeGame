package com.example.gameapi.service.impl;

import com.example.gameapi.dto.UserDto;
import com.example.gameapi.service.AuthContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class DefaultAuthContext implements AuthContext {

  @Override
  public UserDto getUser() {
    return (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }
}
