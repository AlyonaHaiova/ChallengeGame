package com.example.gameapi.service;

import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.FullCardDataDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RandomCardDto;
import com.example.gameapi.meta.Purpose;

import java.util.List;

public interface GameService {
  IdDto create(CreateGameDto createGameDto);

  RandomCardDto getRandomCard(Long gameId, Long roleId, Purpose purpose);

  List<FullCardDataDto> getAllCards(Long gameId);
}
