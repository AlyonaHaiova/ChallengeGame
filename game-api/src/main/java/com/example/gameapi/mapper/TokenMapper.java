package com.example.gameapi.mapper;

import com.auth0.json.auth.TokenHolder;
import com.example.gameapi.dto.TokenDto;
import org.mapstruct.Mapper;

@Mapper
public interface TokenMapper {
  TokenDto toDto(TokenHolder tokenHolder);
}
