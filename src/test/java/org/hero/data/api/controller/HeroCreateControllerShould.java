package org.hero.data.api.controller;

import org.hero.data.api.application.HeroApplicationTestCase;
import org.junit.jupiter.api.Test;

class HeroCreateControllerShould extends HeroApplicationTestCase {

  @Test
  void create_an_existing_hero() throws Exception {
    String body = "{\"name\": \"spiderman\"}";

    assertBadRequest("POST", "/superheros/", body, 409);
  }

  @Test
  void create_an_non_existing_hero() throws Exception {
    String body = "{\"name\": \"iron man\"}";

    assertRequestWithBody("POST", "/superheros/", body, 201);
  }
}