package com.example.gameapi.validator;

import com.example.gameapi.dto.CardDto;

public interface CardValidator extends Validator<CardDto> {
  void ensureIfValid(Long gameId, CardDto card);
}
