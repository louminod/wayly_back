package com.wayly.back.domain;

import java.util.List;

public class PlacesFixture {

  private PlacesFixture() {}

  public static final PlaceId placeId = PlaceId.newId();

  public static final Places placesWithSameThemes = new Places(
    List.of(
      new Place(placeId, "Place 1", "Description 1", AddressesFixture.address(), ThemesFixture.themes),
      new Place(placeId, "Place 2", "Description 2", AddressesFixture.address(), ThemesFixture.themes)
    )
  );

  public static final Places placesWithDifferentThemes = new Places(
    List.of(
      new Place(placeId, "Place 1", "Description 1", AddressesFixture.address(), ThemesFixture.themes),
      new Place(placeId, "Place 2", "Description 2", AddressesFixture.address(), ThemesFixture.themes),
      new Place(placeId, "Place 3", "Description 3", AddressesFixture.address(), new Themes(List.of("theme3")))
    )
  );
}
