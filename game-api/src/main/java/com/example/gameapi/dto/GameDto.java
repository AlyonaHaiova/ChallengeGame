package com.example.gameapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {
  private Long id;
  private Long userId;
  private String title;
  private String description;
  private Integer goal;
  private Boolean isTeam;
}
