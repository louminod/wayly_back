package com.wayly.back.application;

import com.wayly.back.domain.*;
import java.util.Collection;
import java.util.List;
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

  public Collection<Place> create(Collection<PlaceToCreate> placesToCreate) {
    return placesCreator.create(placesToCreate);
  }

  public Optional<Place> get(String name) {
    return places.getByName(name);
  }

  public Collection<Place> getByThemes(Collection<String> themes) {
    return places.getByThemes(themes.stream().map(Theme::new).toList()).orElse(List.of());
  }
}
