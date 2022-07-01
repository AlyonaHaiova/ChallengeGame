package com.example.gameapi.security;

import com.example.gameapi.dto.UserDto;
import com.example.gameapi.model.UserPrincipal;
import com.example.gameapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {
  private final UserService userService;

  @Override
  public AbstractAuthenticationToken convert(Jwt source) {
    UserDto user = userService.findUserByEmail(source.getClaim("https://example.com/email")).orElse(null);
    return new UserPrincipal(user, Collections.emptySet());
  }
}
