package org.hero.data.api.controller;


import java.util.Objects;
import org.hero.data.api.dto.SuperHeroRequest;
import org.hero.data.api.dto.SuperHeroResponse;
import org.hero.data.api.exception.HeroException;
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
                                                  @RequestBody final SuperHeroRequest heroRequest)
    throws HeroException {

    throwBadRequestIfParameterIsBlank(identifier);
    throwBadRequestIfIdFormatNotMatches(identifier);

    if (Objects.isNull(heroRequest.getName())){
      throw new HeroException(HttpStatus.BAD_REQUEST, "Name of super hero is null");
    }

    if (Objects.isNull(this.obtainHeroByIdentifier(identifier))) {
      return ResponseEntity.notFound().build();
    }

    this.modifyHero(identifier, heroRequest);
    return new ResponseEntity<>(new SuperHeroResponse(identifier, heroRequest.getName()),
      HttpStatus.OK);
  }
}
