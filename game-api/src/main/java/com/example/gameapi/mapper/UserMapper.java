package com.example.gameapi.mapper;

import com.example.gameapi.dto.RegisterDto;
import com.example.gameapi.dto.UserDto;
import com.example.gameapi.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
  UserDto toDto(UserEntity userEntity);

  UserEntity toEntity(RegisterDto registerDto);
}
