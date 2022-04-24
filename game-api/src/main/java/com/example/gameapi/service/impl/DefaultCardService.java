package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CreateCardDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.entity.CardEntity;
import com.example.gameapi.mapper.CardMapper;
import com.example.gameapi.repository.CardRepository;
import com.example.gameapi.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCardService implements CardService {
  private final CardMapper cardMapper;
  private final CardRepository cardRepository;

  @Override
  public IdDto create(CreateCardDto createCardDto) {
    CardEntity entity = cardMapper.toEntity(createCardDto);
    cardRepository.save(entity);
    return new IdDto(entity.getId());
  }
}
