package org.hero.data.api.controller;


import java.util.Objects;
import org.hero.data.api.dto.SuperHeroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeroDeleteController extends ApiController{

  @DeleteMapping(value = "/superheros/{identifier}")
  public ResponseEntity<SuperHeroResponse> delete(@PathVariable(value = "identifier") final String identifier) {

    throwBadRequestIfParameterIsBlank(identifier);
    throwBadRequestIfIdFormatNotMatches(identifier);

    if (Objects.isNull(this.obtainHeroByIdentifier(identifier))) {
      return ResponseEntity.notFound().build();
    }

    this.deleteHero(identifier);

    return new ResponseEntity<>(new SuperHeroResponse(), HttpStatus.NO_CONTENT);

    /*return queryService.find(id).map(r -> this.getHeroResponseDeleted(id))
        .orElseGet(() -> ResponseEntity.notFound().build());*/

  }
}
