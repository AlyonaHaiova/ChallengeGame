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
public class CreateCardDto {
  private Long typeId;
  private Long unitId;
  private String description;
  private Role role;
  private Integer rangeBegin;
  private Integer rangeEnd;
}
