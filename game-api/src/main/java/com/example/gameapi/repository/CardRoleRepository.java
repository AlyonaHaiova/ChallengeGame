package com.example.gameapi.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface CardRoleRepository {
  void deleteCardRoles(
      @Param("cardId") Long cardId,
      @Param("roleIds") List<Long> roleIds);

  Set<Long> getRolesIdsByCardId(
      @Param("cardId") Long cardId);

  void saveCardRoles(
      @Param("cardId") Long cardId,
      @Param("roleIds") List<Long> roleIds);

  void deleteByRoleId(
      @Param("roleId") Long roleId);

  void deleteByCardId(
      @Param("cardId") Long cardId);
}
