package com.example.gameapi.service.impl;

import com.auth0.client.auth.AuthAPI;
import com.auth0.exception.Auth0Exception;
import com.auth0.net.SignUpRequest;
import com.example.gameapi.config.ConfigProperties;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RegisterDto;
import com.example.gameapi.entity.UserEntity;
import com.example.gameapi.exception.AuthProviderException;
import com.example.gameapi.mapper.UserMapper;
import com.example.gameapi.repository.UserRepository;
import com.example.gameapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultAuthService implements AuthService {
  private final AuthAPI auth;
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final ConfigProperties configProperties;

  @Override
  public IdDto register(RegisterDto registerDto) {
    SignUpRequest request = auth.signUp(registerDto.getEmail(), registerDto.getPassword().toCharArray(), configProperties.getConnection());
    try {
      UserEntity user = userMapper.toEntity(registerDto);
      userRepository.save(user);
      request.execute();
      return new IdDto(user.getId());
    } catch (Auth0Exception exception) {
      throw new AuthProviderException("An exception happened in AuthProvider trying to do registration");
    }
  }
}
