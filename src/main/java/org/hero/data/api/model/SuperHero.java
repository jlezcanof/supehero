package org.hero.data.api.model;


import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
//@Entity
@Table(name = "HEROS")
public final class SuperHero {

  @Id
  @NotNull
  @Column(name = "identifier", columnDefinition = "identifier")
  private UUID id;

  @NotNull
  private String name;
}
