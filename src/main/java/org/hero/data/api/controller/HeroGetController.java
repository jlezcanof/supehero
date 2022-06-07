package org.hero.data.api.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hero.data.api.dto.SuperHeroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeroGetController {

  @GetMapping(value = "/superheros")
  public ResponseEntity<List<SuperHeroResponse>> list() {

    List<SuperHeroResponse> stringSet = new ArrayList<>();
    stringSet.add(new SuperHeroResponse("identifier1", "spiderman"));
    stringSet.add(new SuperHeroResponse("identifier2", "enjuto"));

    return new ResponseEntity<>(stringSet, HttpStatus.OK);
  }
}
