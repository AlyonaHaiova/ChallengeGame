package com.example.gameapi.repository;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.GameRoleDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RoleDto;
import com.example.gameapi.entity.CardEntity;
import com.example.gameapi.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleRepository {
  List<RoleEntity> getRolesByGameId(
      @Param("gameId") Long gameId);

  void save(
    @Param("entity") RoleEntity entity);

  void update(
      @Param("entity") GameRoleDto entity);

  void deleteById(
      @Param("id") Long id);

  Integer getRolePoints(
      @Param("id") Long id);
}
