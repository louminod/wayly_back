package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;
import java.util.Collection;

public class PlacesCreator {

  private final PlacesRepository repository;

  public PlacesCreator(PlacesRepository places) {
    Assert.notNull("places", places);
    this.repository = places;
  }

  public Collection<Place> create(Collection<PlaceToCreate> placesToCreate) {
    Assert.notNull("placesToCreate", placesToCreate);

    Collection<Place> places = placesToCreate.stream().map(PlaceToCreate::create).toList();
    repository.save(places);

    return places;
  }
}
