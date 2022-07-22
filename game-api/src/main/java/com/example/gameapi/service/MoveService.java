package com.example.gameapi.service;

public interface MoveService {
  Long getLastRoleId (Long gameId);

  Long getNextRoleId (Long gameId);

  void updateLastRoleId (Long gameId, Long nextRoleId);
}
