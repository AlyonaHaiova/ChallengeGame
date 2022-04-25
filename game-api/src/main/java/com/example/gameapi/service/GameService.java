package com.example.gameapi.service;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.meta.Role;

public interface GameService {
  IdDto create(CreateGameDto createGameDto);

  CardDto getRandomCard(int gameId, Role role);
}
