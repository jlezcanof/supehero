package org.hero.data.api.controller;


import java.util.HashSet;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeroGetController {

  @GetMapping(value = "/superheros")
  public ResponseEntity<Set<String>> list () {

    Set<String> stringSet = new HashSet<>();
    stringSet.add("spiderman");
    stringSet.add("enjuto");

    return new ResponseEntity<>(stringSet, HttpStatus.OK);
  }
}
