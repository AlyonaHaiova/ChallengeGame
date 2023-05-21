package com.example.gameapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity {
  private Long id;
  private Long typeId;
  private String description;
  private List<Long> roleIds;
  private Integer points;
}
