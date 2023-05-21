package com.example.gameapi.service.impl;

import com.example.gameapi.repository.MoveRepository;
import com.example.gameapi.repository.RoleRepository;
import com.example.gameapi.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultMoveService implements MoveService {
  private final MoveRepository moveRepository;
  private final RoleRepository roleRepository;

  @Override
  public Long getLastRoleId(Long gameId) {
    return moveRepository.findLastRoleId(gameId);
  }

  @Override
  public Boolean isFirstMove(Long gameId) {
    return moveRepository.findLastRoleId(gameId) == null;
  }

  @Override
  public Long getNextRoleId(Long gameId) {
    return moveRepository.findNextRoleId(gameId, getLastRoleId(gameId));
  }

  @Override
  public void updateLastRoleId(Long gameId, Long nextRoleId) {
    moveRepository.updateLastRoleId(gameId, nextRoleId);
  }

  @Override
  public void deleteMovesForGame(Long gameId) {
    moveRepository.deleteMovesForGame(gameId);
  }

}
