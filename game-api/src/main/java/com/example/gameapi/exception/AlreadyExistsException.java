package com.example.gameapi.exception;

public class AlreadyExistsException extends RuntimeException {
  public AlreadyExistsException(String errorMessage) {
    super(errorMessage);
  }
}

