package com.example.gameapi.repository;

import com.example.gameapi.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleRepository {
  List<RoleEntity> getRolesByGameId(
      @Param("gameId") Long gameId);

  Set<Long> getRolesIdsByCardId(
      @Param("cardId") Long cardId);
}
