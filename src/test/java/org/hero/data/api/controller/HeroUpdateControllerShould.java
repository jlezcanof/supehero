package org.hero.data.api.controller;

import org.hero.data.api.application.HeroApplicationTestCase;
import org.junit.jupiter.api.Test;

class HeroUpdateControllerShould extends HeroApplicationTestCase {

  @Test
  void update_an_existing_hero() throws Exception {
    String identifier   = "ea97f659-6ee7-435f-949a-db617664425e";
    String body = "{\"name\": \"spiderman el malo\"}";

    assertBadRequest("PUT", String.format("/superheros/%s", identifier), body, 200);
  }

  @Test
  void update_an_non_existing_hero() throws Exception {
    String identifier   = "ec50d00c-ecff-4062-921e-53e59254388b";
    String body = "{\"name\": \"spiderman el malo\"}";

    assertBadRequest("PUT", String.format("/superheros/%s", identifier), body, 404);
  }

  @Test
  void update_with_nero_is_null() throws Exception {
    String identifier   = "ec50d00c-ecff-4062-921e-53e59254388b";
    String body = "{\"name\": null}";

    assertBadRequest("PUT", String.format("/superheros/%s", identifier), body, 400);
  }

}