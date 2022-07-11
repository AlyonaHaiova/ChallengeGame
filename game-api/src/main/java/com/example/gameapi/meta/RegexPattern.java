package com.example.gameapi.meta;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RegexPattern {
  public static final String COLOR = "(^#([\\da-f]{3}|[\\da-f]{6}|[\\da-f]{8})$)|(^[a-z]+$)";

  public static final String PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$";
}
