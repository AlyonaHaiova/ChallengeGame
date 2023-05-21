package com.example.gameapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
  private Long id;
  private String authId;
  private String email;
  private String nickname;
  private String firstName;
  private String lastName;
}
