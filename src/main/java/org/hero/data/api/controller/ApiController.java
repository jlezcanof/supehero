package org.hero.data.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.hero.data.api.dto.SuperHeroRequest;
import org.hero.data.api.dto.SuperHeroResponse;

public abstract class ApiController extends AbstractController{

  private List<SuperHeroResponse> data = null;

  public ApiController() {
    data = Arrays.asList(new SuperHeroResponse("identifier1",
      "spiderman"),new SuperHeroResponse("identifier", "enjuto"));
  }


  public void addHero(SuperHeroRequest heroRequest){
    data.add(new SuperHeroResponse(UUID.randomUUID().toString(), heroRequest.getName()));
  }

  public boolean delete(SuperHeroRequest heroRequest){
    return data.removeIf( hero -> heroRequest.getName().equals(hero.getName()));
  }

  public void modifyHero(String identifierHero, SuperHeroRequest heroRequest){
    data.stream().filter(hero -> hero.getIdentifier().equals(identifierHero))
      .findFirst().ifPresent( i ->{
        data.removeIf(hero -> i.getIdentifier().equals(identifierHero));
        data.add(new SuperHeroResponse(UUID.randomUUID().toString(), heroRequest.getName()));
      });
  }

  public List<SuperHeroResponse> obtainList(){
    return this.data;
  }

  public SuperHeroResponse obtainHero(String identifier) {
    //SuperHeroResponse heroResponse = null;
    Optional<SuperHeroResponse> superHeroResponse =
      data.stream().filter(hero -> hero.getIdentifier().equals(identifier)).findFirst();

    if (superHeroResponse.isPresent()) {
      return superHeroResponse.get();
    }
    return new SuperHeroResponse();
  }


}
