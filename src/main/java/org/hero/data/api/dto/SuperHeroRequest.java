package org.hero.data.api.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class SuperHeroRequest implements Serializable{

  private String name;

}
