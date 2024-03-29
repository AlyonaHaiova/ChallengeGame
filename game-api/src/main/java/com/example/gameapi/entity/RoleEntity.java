package com.example.gameapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {
  private Long id;
  private String title;
  private Long gameId;
  private Integer points;
}
