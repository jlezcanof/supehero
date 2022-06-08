package org.hero.data.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.hero.data.api.dto.SuperHeroRequest;
import org.hero.data.api.dto.SuperHeroResponse;

public abstract class ApiController extends AbstractController{

  private List<SuperHeroResponse> data = new ArrayList<>();

  public ApiController() {
    data.addAll(Arrays.asList(
      new SuperHeroResponse("ea97f659-6ee7-435f-949a-db617664425e","spiderman"),
      new SuperHeroResponse("2a1fcb50-da7d-4405-ad03-be566f1c0931 ", "enjuto"),
      new SuperHeroResponse(UUID.randomUUID().toString(), "superman"),
      new SuperHeroResponse(UUID.randomUUID().toString(), "Manolito el fuerte")));
  }


  public SuperHeroResponse addHero(SuperHeroRequest heroRequest){
    SuperHeroResponse superHeroResponse = new SuperHeroResponse(UUID.randomUUID().toString(),
      heroRequest.getName());
    data.add(superHeroResponse);
    return superHeroResponse;
  }

  public boolean deleteHero(String identifier){
    return data.removeIf( hero -> hero.getIdentifier().equals(identifier));
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

  public List<SuperHeroResponse> obtainListCriteria(String nameSuperHero){
    return this.data.stream().filter( hero -> hero.getName().toLowerCase()
      .contains(nameSuperHero)).collect(
      Collectors.toList());
  }



  public SuperHeroResponse obtainHeroByName(String nameSuperHero) {
    Optional<SuperHeroResponse> superHeroResponse =
      data.stream().filter(hero -> hero.getName().equals(nameSuperHero)).findFirst();

    if (superHeroResponse.isPresent()) {
      return superHeroResponse.get();
    }
    return null;
  }

  public SuperHeroResponse obtainHeroByIdentifier(String identifier) {
    Optional<SuperHeroResponse> superHeroResponse =
      data.stream().filter(hero -> hero.getIdentifier().equals(identifier)).findFirst();

    if (superHeroResponse.isPresent()) {
      return superHeroResponse.get();
    }
    return null;
  }


}
