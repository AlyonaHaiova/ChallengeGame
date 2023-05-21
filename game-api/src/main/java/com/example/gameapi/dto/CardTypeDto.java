package com.example.gameapi.dto;

import com.example.gameapi.meta.RegexPattern;
import com.example.gameapi.meta.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardTypeDto {
  private Long id;
  @NotBlank(message = ValidationMessage.TITLE_EMPTY)
  @Size(min = 3, message = ValidationMessage.TITLE_SHORT)
  @Size(max = 20, message = ValidationMessage.TITLE_LONG)
  private String title;
  @Pattern(regexp = RegexPattern.COLOR, message = ValidationMessage.COLOR)
  private String color;
  private Boolean isPlayable;
  private Boolean isPenalty;
}
