package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CreateCardTypeDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.entity.CardTypeEntity;
import com.example.gameapi.mapper.CardTypeMapper;
import com.example.gameapi.repository.CardTypeRepository;
import com.example.gameapi.service.CardTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCardTypeService implements CardTypeService {
  private final CardTypeMapper cardTypeMapper;
  private final CardTypeRepository cardTypeRepository;

  @Override
  public IdDto create(CreateCardTypeDto createCardTypeDto) {
    CardTypeEntity entity = cardTypeMapper.toEntity(createCardTypeDto);
    cardTypeRepository.save(entity);
    return new IdDto(entity.getId());
  }
}
