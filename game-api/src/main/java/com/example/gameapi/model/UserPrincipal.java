package com.example.gameapi.model;

import com.example.gameapi.dto.UserDto;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserPrincipal extends AbstractAuthenticationToken {
  private UserDto user;

  public UserPrincipal(UserDto user, Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.user = user;
  }

  @Override
  public boolean isAuthenticated() {
    return user != null;
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return user;
  }
}
