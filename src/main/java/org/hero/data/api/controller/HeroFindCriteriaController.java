package org.hero.data.api.controller;

import java.util.List;
import java.util.Objects;
import org.hero.data.api.dto.SuperHeroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeroFindCriteriaController extends ApiController{

  @GetMapping(value = "/superheros")
  public ResponseEntity<List<SuperHeroResponse>> list(@RequestParam(value = "name", required =
    false) String nameSuperHero) {
    if (Objects.isNull(nameSuperHero)){
      return new ResponseEntity<>(this.obtainList(),
        HttpStatus.OK);
    }
    return new ResponseEntity<>(this.obtainListCriteria(nameSuperHero),
      HttpStatus.OK);
  }
}
