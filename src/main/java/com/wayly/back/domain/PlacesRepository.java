package com.wayly.back.domain;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PlacesRepository {
  Optional<Collection<Place>> getByThemes(Collection<Theme> themes);

  void save(Collection<Place> places);

  Optional<Place> getByName(String name);

  void deleteAll();

  Collection<Place> getAll();

  Collection<Place> getByCity(String city);
}
