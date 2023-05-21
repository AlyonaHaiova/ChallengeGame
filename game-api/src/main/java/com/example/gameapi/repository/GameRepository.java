package com.example.gameapi.repository;

import com.example.gameapi.entity.GameEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GameRepository {
  void save(@Param("entity") GameEntity entity);

  List<Long> getDistinctGameIdsFromRelatedTables(
      @Param("typeId") Long typeId,
      @Param("roleIds") List<Long> roleIds);

  List<GameEntity> getAllGamesByUserId(
      @Param("userId") Long userId
  );

  void delete(
      @Param("id") Long id
  );
}
