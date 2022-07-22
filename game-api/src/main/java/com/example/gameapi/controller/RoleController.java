package com.example.gameapi.controller;

import com.example.gameapi.dto.RoleDto;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Endpoint.ROLE)
@RequiredArgsConstructor
public class RoleController {
  private final RoleService roleService;

  @GetMapping
  public List<RoleDto> getRoles(
      @PathVariable("gameId") long gameId
  ) {
    return roleService.getRoles(gameId);
  }
}
