package com.wayly.back.application;

import com.wayly.back.domain.*;
import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PlacesApplicationService {

  private final PlacesCreator placesCreator;
  private final PlacesRepository places;

  public PlacesApplicationService(PlacesRepository places) {
    this.placesCreator = new PlacesCreator(places);
    this.places = places;
  }

  public Places create(Collection<PlaceToCreate> placesToCreate) {
    return placesCreator.create(placesToCreate);
  }

  public Optional<Place> get(PlaceId placeId) {
    return places.get(placeId);
  }
}
