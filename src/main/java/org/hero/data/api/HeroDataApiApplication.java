package org.hero.data.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class HeroDataApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(HeroDataApiApplication.class, args);
  }
}
