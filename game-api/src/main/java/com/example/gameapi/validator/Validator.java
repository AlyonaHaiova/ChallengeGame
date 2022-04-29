package com.example.gameapi.validator;

public interface Validator<T> {
  void ensureIfValid(T model);
}
