package com.example.gameapi.dto;

import com.example.gameapi.meta.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
  private Long typeId;
  @NotBlank(message = ValidationMessage.DESCRIPTION_EMPTY)
  @Size(min = 5, message = ValidationMessage.DESCRIPTION_SHORT)
  @Size(max = 200, message = ValidationMessage.CARD_DESCRIPTION_LONG)
  private String description;
  private List<Long> roleIds;
  private Integer points;
}
