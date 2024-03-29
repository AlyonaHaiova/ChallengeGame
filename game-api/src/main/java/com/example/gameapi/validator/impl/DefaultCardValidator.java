package com.example.gameapi.validator.impl;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.repository.GameRepository;
import com.example.gameapi.validator.CardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultCardValidator implements CardValidator {
  private final GameRepository gameRepository;

  @Override
  public void ensureIfValid(CardDto model) {
    List<Long> gameIds = gameRepository.getDistinctGameIdsFromRelatedTables(model.getTypeId(), model.getRoleIds());
    if (gameIds.size() > 1) {
      throw new IllegalArgumentException("Invalid type or roles");
    }
  }

  @Override
  public void ensureIfValid(Long gameId, CardDto model) {
    List<Long> gameIds = gameRepository.getDistinctGameIdsFromRelatedTables(model.getTypeId(), model.getRoleIds());
    if (gameIds.size() > 1 || !gameIds.contains(gameId)) {
      throw new IllegalArgumentException("Invalid type or roles");
    }
  }
}
