package com.example.gameapi.service;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.FullCardDataDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RandomCardDto;

import java.util.List;

public interface CardService {
  IdDto create(CardDto cardDto);
  void update(Long id, CardDto cardDto);

  void delete(Long id);

  RandomCardDto getRandomPlayableCard(Long gameId);

  RandomCardDto getRandomRefreshedPlayableCard(Long gameId);

  RandomCardDto getRandomPenaltyCard(Long gameId);

  List<FullCardDataDto> getAllCards(Long gameId);
}
