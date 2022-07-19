package com.example.gameapi.service.impl;

import com.example.gameapi.repository.MoveRepository;
import com.example.gameapi.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultMoveService implements MoveService {
  private final MoveRepository moveRepository;

  @Override
  public Long getLastRoleId(Long gameId) {
    return moveRepository.findLastRoleId(gameId);
  }

  @Override
  public Long getNextRoleId(Long gameId) {
    return moveRepository.findNextRoleId(gameId, getLastRoleId(gameId));
  }

  @Override
  public void updateLastRoleId(Long gameId, Long nextRoleId) {
    Long last = getLastRoleId(gameId);
    Long next = getNextRoleId(gameId);
    moveRepository.updateLastRoleId(gameId, nextRoleId);
  }
}
