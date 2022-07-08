package com.example.gameapi.dto;

import com.example.gameapi.meta.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {
  @Email(message = ValidationMessage.EMAIL)
  @Size(max = 50, message = ValidationMessage.EMAIL_LONG)
  private String email;
}
