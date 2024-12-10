package com.wayly.back.domain;

public class ItineraryGenerator {

  private final PlacesRepository placesRepository;

  public ItineraryGenerator(PlacesRepository placesRepository) {
    this.placesRepository = placesRepository;
  }

  public Itinerary generate(Themes themes) {
    final Places places = placesRepository.getByThemes(themes).orElseThrow(() -> new NoPlacesFoundException("No places found for themes"));

    return new Itinerary.Builder().places(places).build();
  }
}
