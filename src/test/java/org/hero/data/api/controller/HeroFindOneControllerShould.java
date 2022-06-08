package org.hero.data.api.controller;

import org.hero.data.api.application.HeroApplicationTestCase;
import org.hero.data.api.configuration.H2Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Import({H2Configuration.class})
class HeroFindOneControllerShould extends HeroApplicationTestCase {

  @Test
  void find_an_existing_hero() throws Exception {
    String identifier   = "ea97f659-6ee7-435f-949a-db617664425e";
    String body = "{\"name\": \"spiderman\"}";

    assertResponse(String.format("/superheros/%s", identifier), 200, body);
  }
}