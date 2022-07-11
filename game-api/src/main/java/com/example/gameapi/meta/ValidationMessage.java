package com.example.gameapi.meta;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationMessage {
  public static final String PASSWORD = "Password is not strong enough. It must contain at least 8 chars including at least 1 lowercase letter, 1 uppercase letter, 1 number and 1 special symbol";

  public static final String EMAIL = "Email is incorrect";
  public static final String EMAIL_LONG = "Email is too long (maximum 50 chars)";

  public static final String NICKNAME_EMPTY = "Nickname is mandatory";
  public static final String NICKNAME_SHORT = "Nickname is too short (at least 3 chars)";
  public static final String NICKNAME_LONG = "Nickname is too long (maximum 100 chars)";

  public static final String COLOR = "Color is incorrect";

  public static final String TITLE_EMPTY = "Title is mandatory";
  public static final String TITLE_SHORT = "Title is too short (at least 3 chars)";
  public static final String TITLE_LONG = "Title is too long (maximum 20 chars)";
  public static final String DESCRIPTION_EMPTY = "Description is mandatory";
  public static final String DESCRIPTION_SHORT = "Description is too short (at least 5 chars)";

  public static final String GAME_DESCRIPTION_LONG = "Description is too long (maximum 1000 chars)";
  public static final String CARD_DESCRIPTION_LONG = "Description is too long (maximum 200 chars)";

  public static final String POSITIVE_OR_ZERO_NUMBER = "This number must be 0 or more";
}
