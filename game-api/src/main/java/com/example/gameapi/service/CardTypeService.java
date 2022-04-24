package com.example.gameapi.service;

import com.example.gameapi.dto.CreateCardTypeDto;
import com.example.gameapi.dto.IdDto;

public interface CardTypeService {
  IdDto create(CreateCardTypeDto createCardTypeDto);
}
