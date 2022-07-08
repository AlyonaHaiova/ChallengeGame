package com.example.gameapi.config;

import com.example.gameapi.annotation.Ranged;
import com.example.gameapi.exception.InvalidRangeArgumentsException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Date;

public class RangedValidator implements ConstraintValidator<Ranged, Object> {

  @Override
  public boolean isValid(Object object, ConstraintValidatorContext context) {
    Class<?> objectClass = object.getClass();
    Ranged ranged = objectClass.getAnnotation(Ranged.class);
    String beginField = ranged.begin();
    String endField = ranged.end();
    Field first = findField(objectClass, beginField);
    Field second = findField(objectClass, endField);
    Object begin = getFieldValue(first, object);
    Object end = getFieldValue(second, object);
    return isValidRange(begin, end);
  }

  private Field findField(Class<?> objectClass, String fieldName) {
    try {
      Field field = objectClass.getDeclaredField(fieldName);
      field.setAccessible(true);
      return field;
    } catch (NoSuchFieldException exception) {
      throw new InvalidRangeArgumentsException("Invalid range");
    }

  }

  private Object getFieldValue(Field field, Object object) {
    try {
      return field.get(object);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  private boolean isValidRange(Object begin, Object end) {
    if (!haveComparableTypes(begin, end)) {
      throw new InvalidRangeArgumentsException("Range arguments can`t be validate because of inappropriate type");
    }
    if (begin instanceof Byte) {
      return isValidRange((Byte) begin, (Byte) end);
    } else if (begin instanceof Short) {
      return isValidRange((Short) begin, (Short) end);
    } else if (begin instanceof Integer) {
      return isValidRange((Integer) begin, (Integer) end);
    } else if (begin instanceof Long) {
      return isValidRange((Long) begin, (Long) end);
    } else if (begin instanceof Float) {
      return isValidRange((Float) begin, (Float) end);
    } else if (begin instanceof Double) {
      return isValidRange((Double) begin, (Double) end);
    } else if (begin instanceof Date) {
      return isValidRange((Date) begin, (Date) end);
    }
    return false;
  }

  private boolean haveComparableTypes(Object begin, Object end) {
    return begin.getClass().equals(end.getClass());
  }

  private boolean isValidRange(Byte first, Byte second) {
    return second > first;
  }

  private boolean isValidRange(Short first, Short second) {
    return second > first;
  }

  private boolean isValidRange(Integer first, Integer second) {
    return second > first;
  }

  private boolean isValidRange(Long first, Long second) {
    return second > first;
  }

  private boolean isValidRange(Float first, Float second) {
    return second > first;
  }

  private boolean isValidRange(Double first, Double second) {
    return second > first;
  }

  private boolean isValidRange(Date first, Date second) {
    return second.after(first);
  }
}
