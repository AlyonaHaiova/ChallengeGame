package com.example.gameapi.mapper;

import com.example.gameapi.dto.GameRoleDto;
import com.example.gameapi.dto.RoleDto;
import com.example.gameapi.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
  RoleDto toDto(RoleEntity entity);

  RoleEntity toEntity(RoleDto dto);
}
