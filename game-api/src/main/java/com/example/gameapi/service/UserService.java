package com.example.gameapi.service;

import com.example.gameapi.dto.UserDto;

import java.util.Optional;

public interface UserService {
  Optional<UserDto> findUserByEmail(String email);

  Optional<UserDto> findUserByEmailOrNickname(String email, String nickname);
}
