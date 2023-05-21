package com.example.gameapi.service;

import com.example.gameapi.dto.CardTypeDto;
import com.example.gameapi.dto.CreateCardTypeDto;
import com.example.gameapi.dto.GameCardTypeDto;
import com.example.gameapi.dto.IdDto;

import java.util.List;

public interface CardTypeService {
  IdDto create(CreateCardTypeDto createCardTypeDto);

  List<GameCardTypeDto> getCardTypes(Long gameId);
}
