package org.hero.data.api.repository;

import java.util.UUID;
import org.hero.data.api.model.SuperHero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<SuperHero, UUID> {
}
