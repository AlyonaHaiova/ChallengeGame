package com.example.gameapi.repository;

import com.example.gameapi.entity.CardEntity;
import com.example.gameapi.entity.projection.CardProjection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CardRepository {
  void save(
      @Param("entity") CardEntity entity);

  void update(
      @Param("id") Long id,
      @Param("entity") CardEntity entity);

  void deleteById(
      @Param("id") Long id);

  CardProjection getRandomCard(
      @Param("gameId") Long gameId,
      @Param("next") boolean next,
      @Param("isPlayable") boolean isPlayable,
      @Param("lastRoleId") Long lastRoleId,
      @Param("nextRoleId") Long nextRoleId);

  List<CardProjection> getAllCardsByGameId(
      @Param("gameId") Long gameId);
}
