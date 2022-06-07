package org.hero.data.api.controller;


import java.util.ArrayList;
import java.util.List;
import org.hero.data.api.dto.SuperHeroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeroFindCriteriaController extends ApiController{

  @GetMapping(value = "/superheros")
  public ResponseEntity<List<SuperHeroResponse>> list() {

    return new ResponseEntity<>(this.obtainList(), HttpStatus.OK);
  }
}
