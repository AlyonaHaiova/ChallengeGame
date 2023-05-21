package com.example.gameapi.service;

import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.FullCardDataDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RandomCardDto;
import com.example.gameapi.entity.GameEntity;
import com.example.gameapi.meta.Purpose;

import java.util.List;

public interface GameService {
  IdDto create(CreateGameDto createGameDto);

  List<GameEntity> getGames(Long userId);

  void delete(Long gameId);
}
