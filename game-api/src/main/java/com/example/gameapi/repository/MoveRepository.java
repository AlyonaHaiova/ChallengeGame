package com.example.gameapi.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MoveRepository {
  Long findLastRoleId(
      @Param("gameId") Long gameId);

  Long findNextRoleId(
      @Param("gameId") Long gameId,
      @Param("lastRoleId") Long lastRoleId);

  void updateLastRoleId(
      @Param("gameId") Long gameId,
      @Param("nextRoleId") Long nextRoleId);

  void deleteMovesForGame(
      @Param("gameId") Long gameId);
}
