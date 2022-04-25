package com.example.gameapi.dto;

import com.example.gameapi.meta.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
  private String description;
  private CardTypeDto type;
  private AmountUnitDto unit;
  private Role role;
  private Integer amount;
}
