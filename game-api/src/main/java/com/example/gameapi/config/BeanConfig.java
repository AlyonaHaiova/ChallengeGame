package com.example.gameapi.config;

import com.auth0.client.auth.AuthAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {
  private final Auth0Properties auth0Properties;

  @Bean
  public AuthAPI getAuthApi() {
    return new AuthAPI(auth0Properties.getDomain(), auth0Properties.getClientId(), auth0Properties.getClientSecret());
  }
}
