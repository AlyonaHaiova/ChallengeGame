package com.example.gameapi.dto;

import com.example.gameapi.annotation.Ranged;
import com.example.gameapi.meta.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Ranged(begin = "rangeBegin", end = "rangeEnd", message = "Range is not correct")
public class CardDto {
  private Long typeId;
  private Long unitId;
  @NotBlank(message = ValidationMessage.DESCRIPTION_EMPTY)
  @Size(min = 5, message = ValidationMessage.DESCRIPTION_SHORT)
  @Size(max = 200, message = ValidationMessage.CARD_DESCRIPTION_LONG)
  private String description;
  private List<Long> roleIds;
  @PositiveOrZero(message = ValidationMessage.POSITIVE_OR_ZERO_NUMBER)
  private Integer rangeBegin;
  @PositiveOrZero(message = ValidationMessage.POSITIVE_OR_ZERO_NUMBER)
  private Integer rangeEnd;
}
