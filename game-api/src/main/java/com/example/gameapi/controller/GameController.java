package com.example.gameapi.controller;

import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.FullCardDataDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RandomCardDto;
import com.example.gameapi.dto.RoleDto;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.meta.Purpose;
import com.example.gameapi.service.GameService;
import com.example.gameapi.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Endpoint.GAME)
@RequiredArgsConstructor
public class GameController {
  private final GameService gameService;
  private final RoleService roleService;

  @PostMapping
  public ResponseEntity<IdDto> create(@RequestBody CreateGameDto createGameDto) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(gameService.create(createGameDto));
  }

  @GetMapping("/{gameId}/cards/random")
  public RandomCardDto getRandomCard(
      @PathVariable("gameId") long gameId,
      @RequestParam("roleId") Long roleId,
      @RequestParam(value = "purpose", defaultValue = "PLAYABLE") Purpose purpose
  ) {
    return gameService.getRandomCard(gameId, roleId, purpose);
  }

  @GetMapping("/{gameId}/cards")
  public List<FullCardDataDto> getAllCards(
      @PathVariable("gameId") long gameId
  ) {
    return gameService.getAllCards(gameId);
  }

  @GetMapping("/{gameId}/roles")
  public List<RoleDto> getRoles(
      @PathVariable("gameId") long gameId
  ) {
    return roleService.getRoles(gameId);
  }
}
