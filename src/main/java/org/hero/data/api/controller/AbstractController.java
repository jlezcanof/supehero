package org.hero.data.api.controller;

import java.util.Collections;
import org.hero.data.api.exception.HeroException;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import static org.hero.data.api.properties.RestProperties.PATTERN_UUID;

public abstract  class AbstractController {

  protected void throwBadRequestIfParameterIsBlank(String identifier) {
    if (org.apache.commons.lang3.StringUtils.isBlank(identifier)) {
      throw new HeroException(HttpStatus.BAD_REQUEST, "Field identifier is null");
    }
  }

  protected void throwBadRequestIfIdFormatNotMatches(String identifier) {
    if (!StringUtils.hasText(identifier) || !PATTERN_UUID.matcher(identifier).matches()) {
      throw new HeroException(HttpStatus.BAD_REQUEST, "Field identifier is not pattern of uuid");
    }
  }

  protected void throwConflictIfHeroExists(String nameSuperHero) {
    throw new HeroException(HttpStatus.CONFLICT, String.format("The super hero %s exists",
      nameSuperHero));
  }
}
