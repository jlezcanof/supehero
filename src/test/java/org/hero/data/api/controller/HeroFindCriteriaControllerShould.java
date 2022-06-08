package org.hero.data.api.controller;

import org.hero.data.api.application.HeroApplicationTestCase;
import org.hero.data.api.configuration.H2Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Import({H2Configuration.class})
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