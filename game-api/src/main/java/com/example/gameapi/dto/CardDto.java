package com.example.gameapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
  private Long id;
  private String description;
  private CardTypeDto type;
  private AmountUnitDto unit;
  private List<RoleDto> roles;
  private Integer rangeBegin;
  private Integer rangeEnd;
}
