package com.example.gameapi.service;

import com.example.gameapi.dto.GameRoleDto;
import com.example.gameapi.dto.IdDto;
import com.example.gameapi.dto.RoleDto;
import com.example.gameapi.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
  List<RoleDto> getRoles(Long gameId);

  IdDto save(RoleDto entity);

  void update(GameRoleDto entity);

  void reset(GameRoleDto entity);

  void delete(Long id);
}
