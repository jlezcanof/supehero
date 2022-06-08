package org.hero.data.api.configuration;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.hero.data.api.repository"})
@EntityScan(basePackages = {"org.hero.data.api.model"})
public class H2Configuration {
}
