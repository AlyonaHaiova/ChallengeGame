package com.example.gameapi.entity.projection;

import com.example.gameapi.entity.CardTypeEntity;
import com.example.gameapi.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardProjection {
  private Long id;
  private String description;
  private CardTypeEntity type;
  private List<RoleEntity> roles;
  private RoleEntity role;
  private Integer points;
}
