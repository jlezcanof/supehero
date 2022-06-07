package org.hero.data.api.exception;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.hero.data.api.exception.model.HeroExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public final class ControllerExceptionHandler {

  @ExceptionHandler({HeroException.class})
  public ResponseEntity<HeroExceptionResponse> handleHeroException(HttpServletRequest req, HeroException exception) {
    log.error("Se ha capturado una excepción org.hero.data.api.exception.HeroException: " + exception.getMessage(), exception);

    return new ResponseEntity<>(new HeroExceptionResponse(req.getRequestedSessionId(), exception.getMessage()),
      exception.getStatus());

  }
}
