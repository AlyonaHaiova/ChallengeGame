package com.example.gameapi.repository;

import com.example.gameapi.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleRepository {
  List<RoleEntity> getRolesByGameId(
      @Param("gameId") int gameId);
}
