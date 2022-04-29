package com.example.gameapi.validator.impl;

import com.example.gameapi.dto.CreateCardDto;
import com.example.gameapi.repository.CardRepository;
import com.example.gameapi.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateCardDtoValidator implements Validator<CreateCardDto> {
  private final CardRepository cardRepository;

  @Override
  public void ensureIfValid(CreateCardDto model) {
    List<Long> gameIds = cardRepository.getDistinctGameIdsFromRelatedTables(model.getTypeId(), model.getRoleIds());
    if (gameIds.size() > 1) {
      throw new IllegalArgumentException("Invalid type or roles");
    }
  }
}
