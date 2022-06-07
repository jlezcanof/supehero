package org.hero.data.api.controller;


import org.hero.data.api.dto.SuperHeroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeroFindOneController extends ApiController {

  @GetMapping(value = "/superheros/{identifier}")
  public ResponseEntity<SuperHeroResponse> find(@PathVariable(value = "identifier") final String identifier) {
    throwBadRequestIfParameterIsBlank(identifier);
    throwBadRequestIfIdFormatNotMatches(identifier);

    return new ResponseEntity<>(this.obtainHeroByIdentifier(identifier),
      HttpStatus.OK);
  }
}
