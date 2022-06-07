package org.hero.controller;

import org.hero.application.HeroApplicationTestCase;
import org.junit.jupiter.api.Test;

class HeroUpdateControllerShould extends HeroApplicationTestCase {

  @Test
  void update_an_existing_hero() throws Exception {
    String identifier   = "ea97f659-6ee7-435f-949a-db617664425e";
    String body = "{\"name\": \"spiderman\"}";

    assertResponse(String.format("/superheros/%s", identifier), 200, body);
  }

  void update_an_non_existing_hero() throws Exception {
    String identifier   = "ea97f659-6ee7-435f-949a-db617664425e";
    String body = "{\"name\": \"spiderman\"}";

    assertResponse(String.format("/superheros/%s", identifier), 200, body);
  }
}