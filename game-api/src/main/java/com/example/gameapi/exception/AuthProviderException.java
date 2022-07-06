package com.example.gameapi.exception;

public class AuthProviderException extends RuntimeException {
  public AuthProviderException(String errorMessage) {
    super(errorMessage);
  }
}
