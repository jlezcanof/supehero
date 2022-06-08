package org.hero.data.api.controller;

import org.hero.data.api.application.HeroApplicationTestCase;
import org.hero.data.api.configuration.H2Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Import({H2Configuration.class})
class HeroDeleteControllerShould extends HeroApplicationTestCase {

  @Test
  void delete_an_existing_hero() throws Exception {
    String identifier   = "ea97f659-6ee7-435f-949a-db617664425e";

    assertRequestNoContent("DELETE", String.format("/superheros/%s", identifier), 204);
  }

  @Test
  void delete_an_non_existing_hero() throws Exception {
    String identifier   = "ea97f659-6ee7-435f-949a-db617664425e";

    assertRequestNoContent("DELETE", String.format("/superheros/%s", identifier), 404);
  }

}