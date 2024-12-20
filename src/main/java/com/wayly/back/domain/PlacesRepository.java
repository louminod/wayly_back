package com.wayly.back.domain;

import java.util.Optional;

public interface PlacesRepository {
  Optional<Places> getByThemes(Themes themes);

  void save(Places places);

  Optional<Place> get(PlaceId placeId);
}
