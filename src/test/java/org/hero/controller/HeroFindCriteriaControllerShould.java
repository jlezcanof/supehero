package org.hero.controller;

import org.hero.application.HeroApplicationTestCase;
import org.junit.jupiter.api.Test;

class HeroFindCriteriaControllerShould extends HeroApplicationTestCase {


  @Test
  void obtain_all_super_hero() throws Exception {
    assertRequest("GET", "/superheros/", 200);
  }

}