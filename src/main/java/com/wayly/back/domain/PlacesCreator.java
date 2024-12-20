package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;
import java.util.Collection;

public class PlacesCreator {

  private final PlacesRepository repository;

  public PlacesCreator(PlacesRepository places) {
    Assert.notNull("places", places);
    this.repository = places;
  }

  public Places create(Collection<PlaceToCreate> placesToCreate) {
    Assert.notNull("placesToCreate", placesToCreate);

    Places places = new Places(placesToCreate.stream().map(PlaceToCreate::create).toList());
    repository.save(places);

    return places;
  }
}
