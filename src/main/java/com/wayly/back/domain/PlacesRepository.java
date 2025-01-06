package com.wayly.back.domain;

import java.util.Collection;
import java.util.Optional;

public interface PlacesRepository {
  Optional<Collection<Place>> getByThemes(Collection<Theme> themes);

  void save(Collection<Place> places);
}
