package com.example.gameapi.service;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.IdDto;

public interface CardService {
  IdDto create(CardDto cardDto);

  void update(Long id, CardDto cardDto);
}
