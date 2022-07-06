package com.example.gameapi.service.impl;

import com.example.gameapi.dto.UserDto;
import com.example.gameapi.entity.UserEntity;
import com.example.gameapi.mapper.UserMapper;
import com.example.gameapi.repository.UserRepository;
import com.example.gameapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public Optional<UserDto> findUserByEmail(String email) {
    UserEntity userEntity = userRepository.findUserByEmail(email).orElse(null);
    return Optional.ofNullable(userMapper.toDto(userEntity));
  }

  @Override
  public Optional<UserDto> findUserByEmailOrNickname(String email, String nickname) {
    UserEntity userEntity = userRepository.findUserByEmailOrNickname(email, nickname).orElse(null);
    return Optional.ofNullable(userMapper.toDto(userEntity));
  }
}
