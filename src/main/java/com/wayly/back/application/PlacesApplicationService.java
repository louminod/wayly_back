package com.wayly.back.application;

import com.wayly.back.domain.*;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class PlacesApplicationService {

  private final PlacesCreator placesCreator;

  // private final PlacesRepository places;

  public PlacesApplicationService(PlacesRepository places) {
    this.placesCreator = new PlacesCreator(places);
  }

  public Collection<Place> create(Collection<PlaceToCreate> placesToCreate) {
    return placesCreator.create(placesToCreate);
  }
}
