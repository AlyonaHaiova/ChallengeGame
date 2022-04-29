package com.example.gameapi.controller;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.meta.Purpose;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Endpoint.GAME)
@RequiredArgsConstructor
public class GameController {
  private final GameService gameService;

  @PostMapping
  public ResponseEntity<IdDto> create(@RequestBody CreateGameDto createGameDto) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(gameService.create(createGameDto));
  }

  @GetMapping("/{gameId}/cards/random")
  public CardDto getRandomCard(
      @PathVariable("gameId") int gameId,
      @RequestParam("roleId") Long roleId,
      @RequestParam(value = "purpose", defaultValue = "PLAYABLE") Purpose purpose
      ) {
    return gameService.getRandomCard(gameId, roleId, purpose);
  }
}
