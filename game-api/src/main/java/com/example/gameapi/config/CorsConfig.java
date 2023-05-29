 package com.example.gameapi.config;
 import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 import org.springframework.web.servlet.config.annotation.CorsRegistry;
 import org.springframework.context.annotation.Configuration;
 @Configuration
 @EnableWebMvc
 public class CorsConfig implements WebMvcConfigurer {

   @Override
   public void addCorsMappings(CorsRegistry registry) {
     registry.addMapping("/**")
        .allowedOrigins("http://localhost:3000")
        .allowedMethods("*")
        .allowedHeaders("*")
        .allowCredentials(true);
   }
 }
