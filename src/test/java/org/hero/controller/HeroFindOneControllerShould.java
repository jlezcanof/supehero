package org.hero.controller;

import org.hero.application.HeroApplicationTestCase;
import org.junit.jupiter.api.Test;

class HeroFindOneControllerShould extends HeroApplicationTestCase {


  @Test
  void find_an_existing_hero() throws Exception {
    String identifier   = "identifier1";
    String body = "{\"name\": \"spiderman\"}";

    assertResponse(String.format("/superheros/%s", identifier), 200, body);
  }
}