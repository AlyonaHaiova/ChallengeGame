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
public class RandomCardDto {
  private Long id;
  private String description;
  private CardTypeDto type;
  private List<RoleDto> roles;
  private RoleDto role;
  private Integer points;
}
