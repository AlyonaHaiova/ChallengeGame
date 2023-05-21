package com.example.gameapi.service.impl;

import com.example.gameapi.dto.CardDto;
import com.example.gameapi.dto.GameRoleDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RoleDto;
import com.example.gameapi.entity.CardEntity;
import com.example.gameapi.entity.RoleEntity;
import com.example.gameapi.mapper.RoleMapper;
import com.example.gameapi.repository.CardRoleRepository;
import com.example.gameapi.repository.RoleRepository;
import com.example.gameapi.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultRoleService implements RoleService {
  private final RoleMapper roleMapper;
  private final RoleRepository roleRepository;

  private final CardRoleRepository cardRoleRepository;

  @Override
  public List<RoleDto> getRoles(Long gameId) {
    return roleRepository.getRolesByGameId(gameId).stream()
        .map(roleMapper::toDto)
        .collect(Collectors.toList());
  }

  @Transactional
  @Override
  public IdDto save(RoleDto role) {
    RoleEntity entity = roleMapper.toEntity(role);
    roleRepository.save(entity);
    return new IdDto(entity.getId());
  }

  @Transactional
  @Override
  public void update(GameRoleDto role) {
    Integer old_points = roleRepository.getRolePoints(role.getId());
    role.setPoints(role.getPoints() + old_points);
    roleRepository.update(role);
  }

  @Transactional
  @Override
  public void delete(Long id) {
    roleRepository.deleteById(id);
    cardRoleRepository.deleteByRoleId(id);
  }
}
