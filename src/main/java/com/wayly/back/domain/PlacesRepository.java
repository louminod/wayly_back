package com.wayly.back.domain;

import java.util.Optional;

public interface PlacesRepository {
  Optional<Places> getByThemes(Themes themes);

  void save(Place place);

  Optional<Place> get(PlaceId placeId);
}
