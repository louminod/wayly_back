package com.wayly.back.domain;

import java.util.Collection;
import java.util.List;

public class PlacesFixture {

  private static PlaceId placeId;

  private PlacesFixture() {}

  public static PlaceId placeId() {
    if (placeId == null) {
      placeId = PlaceId.newId();
    }
    return placeId;
  }

  public static Place place() {
    return new Place(placeId(), "Place 1", "Description 1", AddressesFixture.address(), ThemesFixture.themes());
  }

  public static Collection<Place> placesWithSameThemes() {
    return List.of(
      new Place(placeId(), "Place 1", "Description 1", AddressesFixture.address(), ThemesFixture.themes()),
      new Place(placeId(), "Place 2", "Description 2", AddressesFixture.address(), ThemesFixture.themes())
    );
  }

  public static Collection<Place> placesWithDifferentThemes() {
    return List.of(
      new Place(placeId(), "Place 1", "Description 1", AddressesFixture.address(), ThemesFixture.themes()),
      new Place(placeId(), "Place 2", "Description 2", AddressesFixture.address(), ThemesFixture.themes()),
      new Place(placeId(), "Place 3", "Description 3", AddressesFixture.address(), List.of(new Theme("Theme 3")))
    );
  }
}
