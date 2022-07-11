package com.example.gameapi.annotation;

import com.example.gameapi.config.RangedValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RangedValidator.class)
public @interface Ranged {
  String message() default "Invalid range";

  String begin();

  String end();
}
