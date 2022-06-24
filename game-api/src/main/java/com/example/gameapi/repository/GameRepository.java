package com.example.gameapi.repository;

import com.example.gameapi.entity.GameEntity;
import com.example.gameapi.entity.projection.CardProjection;
import com.example.gameapi.meta.Purpose;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GameRepository {
  void save(@Param("entity") GameEntity entity);

  CardProjection getRandomCardByGameIdAndRoleAndCardType(
      @Param("gameId") Long gameId,
      @Param("roleId") Long roleId,
      @Param("purpose") Purpose purpose);

  List<CardProjection> getAllCardsByGameId(
      @Param("gameId") Long gameId);
}
