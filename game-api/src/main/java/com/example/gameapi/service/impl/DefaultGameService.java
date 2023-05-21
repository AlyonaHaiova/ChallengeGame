package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RandomCardDto;
import com.example.gameapi.entity.GameEntity;
import com.example.gameapi.mapper.GameMapper;
import com.example.gameapi.repository.GameRepository;
import com.example.gameapi.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultGameService implements GameService {
  private final GameRepository gameRepository;
  private final GameMapper gameMapper;

  @Override
  public IdDto create(CreateGameDto createGameDto) {
    GameEntity gameEntity = gameMapper.toEntity(createGameDto);
    gameRepository.save(gameEntity);
    return new IdDto(gameEntity.getId());
  }

  @Override
  @Transactional
  public List<GameEntity> getGames(Long userId) {
    return gameRepository.getAllGamesByUserId(userId);
  }

  @Override
  public void delete(Long gameId) {
    gameRepository.delete(gameId);
  }
}
