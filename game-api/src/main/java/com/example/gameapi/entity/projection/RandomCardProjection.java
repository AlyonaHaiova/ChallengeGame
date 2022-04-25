package com.example.gameapi.entity.projection;

import com.example.gameapi.entity.AmountUnitEntity;
import com.example.gameapi.entity.CardTypeEntity;
import com.example.gameapi.meta.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RandomCardProjection {
  private String description;
  private CardTypeEntity type;
  private AmountUnitEntity unit;
  private Role role;
  private Integer rangeBegin;
  private Integer rangeEnd;
}
