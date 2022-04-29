package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.entity.GameEntity;
import com.example.gameapi.entity.projection.RandomCardProjection;
import com.example.gameapi.mapper.CardMapper;
import com.example.gameapi.mapper.GameMapper;
import com.example.gameapi.meta.Purpose;
import com.example.gameapi.repository.GameRepository;
import com.example.gameapi.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class DefaultGameService implements GameService {
  private static final Random RANDOM = new Random();

  private final GameRepository gameRepository;
  private final GameMapper gameMapper;
  private final CardMapper cardMapper;

  @Override
  public IdDto create(CreateGameDto createGameDto) {
    GameEntity gameEntity = gameMapper.toEntity(createGameDto);
    gameRepository.save(gameEntity);
    return new IdDto(gameEntity.getId());
  }

  @Override
  public CardDto getRandomCard(int gameId, Long roleId, Purpose purpose) {
    RandomCardProjection cardProjection = gameRepository.getRandomCardByGameIdAndRoleAndCardType(gameId, roleId, purpose);
    if (cardProjection == null) {
      return null;
    }
    CardDto card = cardMapper.toDto(cardProjection);
    card.setAmount(generateAmount(cardProjection.getRangeBegin(), cardProjection.getRangeEnd()));
    return card;
  }

  private int generateAmount(int rangeBegin, int rangeEnd) {
    return RANDOM.nextInt(rangeEnd - rangeBegin + 1) + rangeBegin;
  }
}
