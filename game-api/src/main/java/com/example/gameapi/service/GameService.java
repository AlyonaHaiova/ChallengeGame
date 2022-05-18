package com.example.gameapi.service;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RoleDto;
import com.example.gameapi.meta.Purpose;

import java.util.List;

public interface GameService {
  IdDto create(CreateGameDto createGameDto);

  CardDto getRandomCard(int gameId, Long roleId, Purpose purpose);

  List<CardDto> getAllCards(int gameId);
}
