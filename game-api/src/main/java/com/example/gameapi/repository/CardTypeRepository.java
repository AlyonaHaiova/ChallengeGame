package com.example.gameapi.repository;

import com.example.gameapi.entity.CardTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardTypeRepository {
  void save(@Param("entity") CardTypeEntity entity);

  Long getGameIdByCardId(
      @Param("cardId") Long cardId);
}
