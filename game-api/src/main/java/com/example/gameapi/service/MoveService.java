package com.example.gameapi.service;

public interface MoveService {
  Long getLastRoleId (Long gameId);

  Long getNextRoleId (Long gameId);

  Boolean isFirstMove(Long gameId);

  void updateLastRoleId (Long gameId, Long nextRoleId);

  void deleteMovesForGame(Long gameId);
}
