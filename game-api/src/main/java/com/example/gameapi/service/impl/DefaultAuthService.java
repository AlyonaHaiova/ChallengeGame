package com.example.gameapi.service.impl;

import com.auth0.client.auth.AuthAPI;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.auth.TokenHolder;
import com.auth0.net.AuthRequest;
import com.auth0.net.Request;
import com.auth0.net.SignUpRequest;
import com.example.gameapi.config.Auth0Properties;
import com.example.gameapi.dto.EmailDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.LoginDto;
import com.example.gameapi.dto.MessageDto;
import com.example.gameapi.dto.RegisterDto;
import com.example.gameapi.dto.TokenDto;
import com.example.gameapi.entity.UserEntity;
import com.example.gameapi.exception.AlreadyExistsException;
import com.example.gameapi.exception.AuthProviderException;
import com.example.gameapi.mapper.TokenMapper;
import com.example.gameapi.mapper.UserMapper;
import com.example.gameapi.repository.UserRepository;
import com.example.gameapi.service.AuthService;
import com.example.gameapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultAuthService implements AuthService {
  private final AuthAPI auth;
  private final UserRepository userRepository;
  private final UserService userService;
  private final UserMapper userMapper;
  private final Auth0Properties auth0Properties;
  private final TokenMapper tokenMapper;

  @Transactional
  @Override
  public IdDto register(RegisterDto registerDto) {
    userService.findUserByEmailOrNickname(registerDto.getEmail(), registerDto.getNickname())
        .ifPresent(userDto -> {
          throw new AlreadyExistsException("User with this email or nickname already exists");
        });
    SignUpRequest request = auth.signUp(registerDto.getEmail(), registerDto.getPassword().toCharArray(), auth0Properties.getConnection());
    UserEntity user = userMapper.toEntity(registerDto);
    userRepository.save(user);
    executeRequest(request);
    return new IdDto(user.getId());
  }

  @Override
  public TokenDto login(LoginDto loginDto) {
    AuthRequest request = auth.login(loginDto.getEmail(), loginDto.getPassword().toCharArray(), auth0Properties.getConnection())
        .setAudience(auth0Properties.getAudience())
        .setScope(auth0Properties.getScope());
    TokenHolder holder = executeRequest(request);
    return tokenMapper.toDto(holder);
  }

  @Override
  public TokenDto renewAuth(TokenDto expiredTokenDto) {
    AuthRequest request = auth.renewAuth(expiredTokenDto.getRefreshToken())
        .setScope(auth0Properties.getScope());
    TokenHolder holder = executeRequest(request);
    return tokenMapper.toDto(holder);
  }

  @Override
  public MessageDto resetPassword(EmailDto emailDto) {
    Request<Void> request = auth.resetPassword(emailDto.getEmail(), auth0Properties.getConnection());
    executeRequest(request);
    return new MessageDto("Email was sent");
  }

  private <T> T executeRequest(Request<T> request) {
    try {
      return request.execute();
    } catch (Auth0Exception exception) {
      throw new AuthProviderException("An exception happened in AuthProvider trying to login");
    }
  }
}
