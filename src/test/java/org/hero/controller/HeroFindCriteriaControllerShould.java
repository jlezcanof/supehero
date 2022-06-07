package org.hero.controller;

import org.hero.application.HeroApplicationTestCase;
import org.junit.jupiter.api.Test;

class HeroFindCriteriaControllerShould extends HeroApplicationTestCase {

  @Test
  void obtain_all_super_hero() throws Exception {
    assertRequest("GET", "/superheros/", 200);
  }

  @Test
  void obtain_list_hero_filtered_by_name() throws Exception {
    String keyQueryParam = "name";
    String valueQueryParam = "man";

    String bodyResponse = "man";

    assertResponse("/superheros/", 200, keyQueryParam, valueQueryParam, bodyResponse);
  }

}