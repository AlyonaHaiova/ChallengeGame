package com.example.gameapi.service;

import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.IdDto;

public interface GameService {
  IdDto create(CreateGameDto createGameDto);
}
