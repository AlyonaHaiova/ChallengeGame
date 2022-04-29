package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CreateCardDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.entity.CardEntity;
import com.example.gameapi.mapper.CardMapper;
import com.example.gameapi.repository.CardRepository;
import com.example.gameapi.service.CardService;
import com.example.gameapi.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultCardService implements CardService {
  private final CardMapper cardMapper;
  private final CardRepository cardRepository;
  private final Validator<CreateCardDto> createCardValidator;

  @Transactional
  @Override
  public IdDto create(CreateCardDto createCardDto) {
    createCardValidator.ensureIfValid(createCardDto);
    CardEntity entity = cardMapper.toEntity(createCardDto);
    cardRepository.save(entity);
    cardRepository.saveCardRoles(entity.getId(), createCardDto.getRoleIds());
    return new IdDto(entity.getId());
  }
}
