package org.hero.data.api.controller;


import org.hero.data.api.dto.SuperHeroRequest;
import org.hero.data.api.dto.SuperHeroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeroUpdateController extends ApiController {

  @PutMapping(value = "/superheros/{identifier}")
  public ResponseEntity<SuperHeroResponse> update(@PathVariable(value = "identifier") final String identifier,
                                                  @RequestBody final SuperHeroRequest heroRequest) {

    throwBadRequestIfParameterIsBlank(identifier);
    throwBadRequestIfIdFormatNotMatches(identifier);

    // WIP
    this.modifyHero(identifier, heroRequest);
    return new ResponseEntity<>(new SuperHeroResponse(identifier, heroRequest.getName()),
      HttpStatus.OK);
  }
}
