package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CreateCardTypeDto;
import com.example.gameapi.dto.GameCardTypeDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.entity.CardTypeEntity;
import com.example.gameapi.mapper.CardTypeMapper;
import com.example.gameapi.repository.CardTypeRepository;
import com.example.gameapi.service.CardTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultCardTypeService implements CardTypeService {
  private final CardTypeMapper cardTypeMapper;
  private final CardTypeRepository cardTypeRepository;

  @Override
  public List<GameCardTypeDto> getCardTypes(Long gameId) {
    return cardTypeRepository.getCardTypesByGameId(gameId)
        .stream()
        .map(cardTypeMapper::toDto).collect(Collectors.toList());
  }

  @Override
  public IdDto create(CreateCardTypeDto createCardTypeDto) {
    CardTypeEntity entity = cardTypeMapper.toEntity(createCardTypeDto);
    cardTypeRepository.save(entity);
    return new IdDto(entity.getId());
  }
}
