package org.hero.data.api.controller;


import java.util.Objects;
import org.hero.data.api.dto.SuperHeroRequest;
import org.hero.data.api.dto.SuperHeroResponse;
import org.hero.data.api.exception.HeroException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeroCreateController extends ApiController{

  @PostMapping(value = "/superheros/")
  public ResponseEntity<SuperHeroResponse> save(@RequestBody final SuperHeroRequest heroRequest) {

    if (Objects.isNull(heroRequest.getName())){
      throw new HeroException(HttpStatus.BAD_REQUEST, "Name of super hero is null");
    }


    return new ResponseEntity<>(new SuperHeroResponse("identifier", "name"), HttpStatus.OK);
  }
}
