package org.hero.data.api.dto;

public final class SuperHeroResponse {

  private String identifier;//format uuid

  private String name;

  public SuperHeroResponse(String identifier, String name){
    this.identifier = identifier;
    this.name = name;
  }

  public String identifier(){
    return this.identifier;
  };

  public String name(){
    return this.name;
  }
}
