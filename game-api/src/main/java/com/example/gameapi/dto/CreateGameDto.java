package com.example.gameapi.dto;

import com.example.gameapi.meta.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateGameDto {
  @NotBlank(message = ValidationMessage.TITLE_EMPTY)
  @Size(min = 3, message = ValidationMessage.TITLE_SHORT)
  @Size(max = 20, message = ValidationMessage.TITLE_LONG)
  private String title;
  @NotBlank(message = ValidationMessage.DESCRIPTION_EMPTY)
  @Size(min = 5, message = ValidationMessage.DESCRIPTION_SHORT)
  @Size(max = 1000, message = ValidationMessage.GAME_DESCRIPTION_LONG)
  private String description;
  private Long userId;
}
