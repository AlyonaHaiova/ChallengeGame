package com.example.gameapi;

import com.example.gameapi.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class GameApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(GameApiApplication.class, args);
  }

}
