package com.example.gameapi.service;

import com.example.gameapi.dto.RoleDto;

import java.util.List;

public interface RoleService {
  List<RoleDto> getRoles(int gameId);
}
