package com.example.gameapi.utils;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class CollectionUtils {
  public static <T> Set<T> getDifference(Set<T> firstSet, Set<T> secondSet) {
    Set<T> difference = new HashSet<>(firstSet);
    difference.removeAll(secondSet);
    return difference;
  }
}
