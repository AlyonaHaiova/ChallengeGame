package com.example.gameapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "auth0")
public class Auth0Properties {
  private String connection;
  private String domain;
  private String clientId;
  private String clientSecret;
  private String scope;
  private String audience;
}
