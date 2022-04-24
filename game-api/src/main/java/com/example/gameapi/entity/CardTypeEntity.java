package com.example.gameapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardTypeEntity {
  private Long id;
  private Long gameId;
  private String title;
  private String color;
}
