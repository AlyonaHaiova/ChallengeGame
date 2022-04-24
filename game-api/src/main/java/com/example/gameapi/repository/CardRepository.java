package com.example.gameapi.repository;

import com.example.gameapi.entity.CardEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardRepository {
  void save(@Param("entity") CardEntity entity);
}
