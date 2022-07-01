package com.example.gameapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameEntity {
  private Long id;
  private Long userId;
  private String title;
  private String description;
}
