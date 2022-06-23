package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.FullCardDataDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RandomCardDto;
import com.example.gameapi.entity.GameEntity;
import com.example.gameapi.entity.projection.CardProjection;
import com.example.gameapi.mapper.CardMapper;
import com.example.gameapi.mapper.GameMapper;
import com.example.gameapi.meta.Purpose;
import com.example.gameapi.repository.GameRepository;
import com.example.gameapi.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
  public RandomCardDto getRandomCard(Long gameId, Long roleId, Purpose purpose) {
    CardProjection cardProjection = gameRepository.getRandomCardByGameIdAndRoleAndCardType(gameId, roleId, purpose);
    if (cardProjection == null) {
      return null;
    }
    RandomCardDto card = cardMapper.toRandomCardDto(cardProjection);
    card.setAmount(generateAmount(cardProjection.getRangeBegin(), cardProjection.getRangeEnd()));
    return card;
  }

  @Override
  public List<FullCardDataDto> getAllCards(Long gameId) {
    return gameRepository.getAllCardsByGameId(gameId).stream()
        .map(cardMapper::toCardDto)
        .collect(Collectors.toList());
  }

  private int generateAmount(int rangeBegin, int rangeEnd) {
    return RANDOM.nextInt(rangeEnd - rangeBegin + 1) + rangeBegin;
  }
}
