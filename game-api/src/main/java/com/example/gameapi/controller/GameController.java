package com.example.gameapi.controller;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.FullCardDataDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.entity.GameEntity;
import com.example.gameapi.meta.Endpoint;
import com.example.gameapi.service.GameService;
import com.example.gameapi.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Endpoint.GAME)
@RequiredArgsConstructor
public class GameController {
  private final GameService gameService;
  private final MoveService moveService;

  @PostMapping
  public ResponseEntity<IdDto> create(
      @Valid @RequestBody CreateGameDto createGameDto
  ) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(gameService.create(createGameDto));
  }

  @GetMapping("/{userId}")
  public List<GameEntity> getAllGamesOfUser(
      @PathVariable("userId") long userId
  ) {
    return gameService.getGames(userId);
  }

  @DeleteMapping("/{id}")
  public void delete(
      @PathVariable("id") long gameId
  ) {
    moveService.deleteMovesForGame(gameId);
    gameService.delete(gameId);
  }
}
