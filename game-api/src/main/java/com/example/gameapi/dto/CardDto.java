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
  private Long typeId;
  private Long unitId;
  private String description;
  private List<Long> roleIds;
  private Integer rangeBegin;
  private Integer rangeEnd;
}
