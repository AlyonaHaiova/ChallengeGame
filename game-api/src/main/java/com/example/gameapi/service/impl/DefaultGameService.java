package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.entity.GameEntity;
import com.example.gameapi.mapper.GameMapper;
import com.example.gameapi.repository.GameRepository;
import com.example.gameapi.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
