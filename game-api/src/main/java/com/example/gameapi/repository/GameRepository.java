package com.example.gameapi.repository;

import com.example.gameapi.entity.GameEntity;
import com.example.gameapi.entity.projection.RandomCardProjection;
import com.example.gameapi.meta.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GameRepository {
  void save(@Param("entity") GameEntity entity);

  RandomCardProjection getRandomCardByGameIdAndRole(
      @Param("gameId") int gameId,
      @Param("role") Role role);
}
