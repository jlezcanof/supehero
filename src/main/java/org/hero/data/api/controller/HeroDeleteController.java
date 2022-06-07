package org.hero.data.api.controller;


import org.hero.data.api.dto.SuperHeroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeroDeleteController {

  @DeleteMapping(value = "/superheros/{identifier}")
  public ResponseEntity<SuperHeroResponse> find(@PathVariable(value = "identifier") final String id) {

    /*Set<SuperHeroResponse> stringSet = new HashSet<>();
    stringSet.add(new SuperHeroResponse("identifier", "spiderman"));
    stringSet.add(new SuperHeroResponse("identifier", "enjuto"));*/

    return new ResponseEntity<>(new SuperHeroResponse("identifier", "name"), HttpStatus.OK);
  }
}
