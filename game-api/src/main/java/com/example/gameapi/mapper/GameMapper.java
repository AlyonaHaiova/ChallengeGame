package com.example.gameapi.mapper;

import com.example.gameapi.dto.CreateGameDto;
import com.example.gameapi.entity.GameEntity;
import org.mapstruct.Mapper;

@Mapper
public interface GameMapper {
  GameEntity toEntity(CreateGameDto dto);
}
