package com.example.gameapi.repository;

import com.example.gameapi.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserRepository {
  Optional<UserEntity> findUserByEmail(
      @Param("email") String email);

  void save(
      @Param("entity") UserEntity userEntity);
}
