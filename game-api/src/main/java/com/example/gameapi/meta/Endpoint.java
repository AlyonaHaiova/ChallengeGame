package com.example.gameapi.meta;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Endpoint {
  private static final String API_PREFIX = "/api";
  public static final String GAME = API_PREFIX + "/games";
  public static final String CARD_TYPE = API_PREFIX + "/card-types";
  public static final String CARD = API_PREFIX + "/cards";
}
