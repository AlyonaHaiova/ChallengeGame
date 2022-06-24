package com.example.gameapi.repository;

import com.example.gameapi.entity.CardEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CardRepository {
  void save(
      @Param("entity") CardEntity entity);

  void update(
      @Param("id") Long id,
      @Param("entity") CardEntity entity);

  List<Long> getDistinctGameIdsFromRelatedTables(
      @Param("typeId") Long typeId,
      @Param("roleIds") List<Long> roleIds);

  void saveCardRoles(
      @Param("cardId") Long cardId,
      @Param("roleIds") List<Long> roleIds);
}
