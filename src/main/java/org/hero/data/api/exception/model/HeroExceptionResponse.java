package org.hero.data.api.exception.model;

import lombok.Data;

@Data
public final class HeroExceptionResponse {

  private String message;
  private String requestId;

  public HeroExceptionResponse(final String requestId, final String message) {
    this.message = message;
    this.requestId = requestId;
  }

}
