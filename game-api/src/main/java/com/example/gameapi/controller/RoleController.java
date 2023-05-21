package com.example.gameapi.controller;

import com.example.gameapi.dto.GameRoleDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RoleDto;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

  @PostMapping
  public ResponseEntity<IdDto> create(
      @Valid @RequestBody RoleDto roleDto
  ) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(roleService.save(roleDto));
  }

  @PostMapping("/points")
  public void update(
      @Valid @RequestBody GameRoleDto roleDto
  ) {
    roleService.update(roleDto);
  }
}
