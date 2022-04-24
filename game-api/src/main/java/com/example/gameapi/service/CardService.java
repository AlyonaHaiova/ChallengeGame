package com.example.gameapi.service;

import com.example.gameapi.dto.CreateCardDto;
import com.example.gameapi.dto.IdDto;

public interface CardService {
  IdDto create(CreateCardDto createCardDto);
}
