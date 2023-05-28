package com.example.gameapi.service;

import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.entity.GameEntity;

import java.util.List;

public interface GameService {
  IdDto create(CreateGameDto createGameDto);

  List<GameEntity> getGames(Long userId);

  GameEntity getGame(Long id);

  void changeMode(Long gameId);

  void delete(Long gameId);
}
