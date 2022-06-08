package org.hero.data.api.controller;

import org.hero.data.api.application.HeroApplicationTestCase;
import org.hero.data.api.configuration.H2Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Import({H2Configuration.class})
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