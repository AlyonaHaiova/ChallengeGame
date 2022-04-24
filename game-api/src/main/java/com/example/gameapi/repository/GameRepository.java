package com.example.gameapi.repository;

import com.example.gameapi.entity.GameEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GameRepository {
  void save(@Param("entity") GameEntity entity);
}
