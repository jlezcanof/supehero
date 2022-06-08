package org.hero.controller;

import org.hero.application.HeroApplicationTestCase;
import org.junit.jupiter.api.Test;

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