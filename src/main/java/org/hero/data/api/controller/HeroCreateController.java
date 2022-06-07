package org.hero.data.api.controller;


import org.hero.data.api.dto.SuperHeroRequest;
import org.hero.data.api.dto.SuperHeroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeroCreateController extends ApiController{

  @PostMapping(value = "/superheros/{identifier}")
  public ResponseEntity<SuperHeroResponse> save(@RequestBody final SuperHeroRequest heroRequest) {



    return new ResponseEntity<>(new SuperHeroResponse("identifier", "name"), HttpStatus.OK);
  }
}
