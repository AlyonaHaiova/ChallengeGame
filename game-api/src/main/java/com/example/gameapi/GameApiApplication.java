package com.example.gameapi;

import com.example.gameapi.config.Auth0Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Auth0Properties.class)
public class GameApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(GameApiApplication.class, args);
  }

}
