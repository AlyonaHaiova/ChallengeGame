package com.example.gameapi.mapper;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.CreateCardDto;
import com.example.gameapi.entity.CardEntity;
import com.example.gameapi.entity.projection.RandomCardProjection;
import org.mapstruct.Mapper;

@Mapper
public interface CardMapper {
  CardEntity toEntity(CreateCardDto dto);

  CardDto toDto(RandomCardProjection projection);
}
