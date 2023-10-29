package com.task.mongodb.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class that provides functionality for converting between different objects.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Mapper {
  private static final ModelMapper modelMapper = new ModelMapper();

  public static <D, T> D convert(T entity, Class<D> convertClass) {
    return entity != null ? modelMapper.map(entity, convertClass) : null;
  }

  public static <D, T> List<D> convertAll(final Collection<T> entityList, Class<D> outClass) {
    return entityList.stream()
        .map(entity -> convert(entity, outClass))
        .collect(Collectors.toList());
  }
}
