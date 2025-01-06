package com.wayly.back.domain;

import java.util.Collection;

public class ItineraryGenerator {

  private final PlacesRepository placesRepository;

  public ItineraryGenerator(PlacesRepository placesRepository) {
    this.placesRepository = placesRepository;
  }

  public Itinerary generate(Collection<Theme> themes) {
    final Collection<Place> places = placesRepository
      .getByThemes(themes)
      .orElseThrow(() -> new NoPlacesFoundException("No places found for themes"));

    return new Itinerary.Builder().places(places).build();
  }
}
