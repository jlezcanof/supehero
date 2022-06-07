package org.hero.data.api.controller;

import org.springframework.util.StringUtils;
import static org.hero.data.api.properties.RestProperties.PATTERN_UUID;

public abstract  class AbstractController {

  protected void throwBadRequestIfParameterIsBlank(String identifier) {
    if (org.apache.commons.lang3.StringUtils.isBlank(identifier)) {

    }
  }

  protected void throwBadRequestIfIdFormatNotMatches(String identifier) {
    if (!StringUtils.hasText(identifier) || !PATTERN_UUID.matcher(identifier).matches()) {

    }
  }
}
