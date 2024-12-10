package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;

public class PlacesCreator {

  private final PlacesRepository places;

  public PlacesCreator(PlacesRepository places) {
    Assert.notNull("places", places);
    this.places = places;
  }

  public Place create(PlaceToCreate placeToCreate) {
    Assert.notNull("placeToCreate", placeToCreate);

    Place place = placeToCreate.create();
    places.save(place);

    return place;
  }
}
