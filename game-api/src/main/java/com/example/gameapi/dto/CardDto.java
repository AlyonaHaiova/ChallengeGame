package com.example.gameapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
  private Long id;
  private String description;
  private CardTypeDto type;
  private AmountUnitDto unit;
  private RoleDto role;
  private Integer amount;
}
