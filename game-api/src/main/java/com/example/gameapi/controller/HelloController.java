package com.example.gameapi.controller;

import com.example.gameapi.meta.Endpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoint.CHECK)
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "Hello, World!!!";
  }
}
