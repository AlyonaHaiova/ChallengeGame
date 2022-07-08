package com.example.gameapi.exception;

public class InvalidRangeArgumentsException extends RuntimeException {
  public InvalidRangeArgumentsException(String errorMessage) {
    super(errorMessage);
  }
}
