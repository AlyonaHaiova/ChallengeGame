package com.example.gameapi.dto;

import com.example.gameapi.meta.RegexPattern;
import com.example.gameapi.meta.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
  @NotBlank(message = ValidationMessage.NICKNAME_EMPTY)
  @Size(min = 3, message = ValidationMessage.NICKNAME_SHORT)
  @Size(max = 100, message = ValidationMessage.NICKNAME_LONG)
  private String nickname;
  @Email(message = ValidationMessage.EMAIL)
  @Size(max = 50, message = ValidationMessage.EMAIL_LONG)
  private String email;
  @Pattern(regexp = RegexPattern.PASSWORD, message = ValidationMessage.PASSWORD)
  private String password;
}
