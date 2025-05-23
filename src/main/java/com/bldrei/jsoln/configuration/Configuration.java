package com.bldrei.jsoln.configuration;

import com.bldrei.jsoln.cache.Cache;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public final class Configuration {
  private final DateTimeFormatter dateTimeFormatter;
  private final RequiredFieldsDefinitionMode requiredFieldsDefinitionMode;
  private final Cache cache;

  public static Configuration defaultConf() {
    return new Configuration(null, RequiredFieldsDefinitionMode.STRICT, new Cache());
  }

  public Configuration(RequiredFieldsDefinitionMode requiredFieldsDefinitionMode) {
    this(null, requiredFieldsDefinitionMode, new Cache());
  }
}
