package com.example.gameapi.mapper;

import com.example.gameapi.dto.CardTypeDto;
import com.example.gameapi.dto.CreateCardTypeDto;
import com.example.gameapi.dto.GameCardTypeDto;
import com.example.gameapi.entity.CardTypeEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CardTypeMapper {
  CardTypeEntity toEntity(CreateCardTypeDto dto);

  GameCardTypeDto toDto(CardTypeEntity entity);
}
