package com.wayly.back.infrastructure.secondary;

import com.wayly.back.domain.*;
import com.wayly.back.shared.error.domain.Assert;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPlacesRepository implements PlacesRepository {

  private final Map<PlaceId, Place> places = new ConcurrentHashMap<>();

  @Override
  public Optional<Collection<Place>> getByThemes(Collection<Theme> themes) {
    Assert.notNull("themes", themes);

    List<Place> list = places.values().stream().filter(place -> place.themes().containsAll(themes)).sorted().toList();

    return Optional.of(list);
  }

  @Override
  public void save(Collection<Place> places) {
    Assert.notNull("places", places);

    places.forEach(place -> this.places.put(place.id(), place));
  }

  @Override
  public Optional<Place> getByName(String name) {
    Assert.notNull("name", name);

    return places.values().stream().filter(place -> place.name().equals(name)).findFirst();
  }

  @Override
  public void deleteAll() {
    places.clear();
  }
}
