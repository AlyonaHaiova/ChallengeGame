package com.example.gameapi.service.impl;

import com.example.gameapi.dto.RoleDto;
import com.example.gameapi.mapper.RoleMapper;
import com.example.gameapi.repository.RoleRepository;
import com.example.gameapi.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultRoleService implements RoleService {
  private final RoleMapper roleMapper;
  private final RoleRepository roleRepository;

  @Override
  public List<RoleDto> getRoles(int gameId) {
    return roleRepository.getRolesByGameId(gameId).stream()
        .map(roleMapper::toDto)
        .collect(Collectors.toList());
  }
}
