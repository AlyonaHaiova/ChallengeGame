package com.example.gameapi.config;

import com.auth0.client.auth.AuthAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {
  private final ConfigProperties configProperties;

  @Bean
  public AuthAPI getAuthApi() {
    return new AuthAPI(configProperties.getDomain(), configProperties.getClientId(), configProperties.getClientSecret());
  }
}
