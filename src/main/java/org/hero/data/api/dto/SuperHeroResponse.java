package org.hero.data.api.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class SuperHeroResponse implements Serializable{

  private  String identifier;//format uuid

  private String name;

}
