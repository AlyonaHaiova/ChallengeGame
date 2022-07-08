package com.example.gameapi.annotation;

import com.example.gameapi.config.RangedValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({ElementType.TYPE, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RangedValidator.class)
public @interface Ranged {
  String message() default "Invalid range";

  String begin();

  String end();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
