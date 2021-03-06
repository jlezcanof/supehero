package org.hero.data.api.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public final class HeroException extends RuntimeException {
  private static final long serialVersionUID = 4251129815918670347L;
  private final HttpStatus status;
  private final String messageError;

  public HeroException(HttpStatus status, String messageError){
    this.status = status;
    this.messageError = messageError;
  }
}
