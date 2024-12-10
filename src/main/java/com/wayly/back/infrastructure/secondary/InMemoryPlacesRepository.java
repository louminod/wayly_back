package com.wayly.back.infrastructure.secondary;

import com.wayly.back.domain.*;
import com.wayly.back.shared.error.domain.Assert;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPlacesRepository implements PlacesRepository {

  private final Map<PlaceId, Place> places = new ConcurrentHashMap<>();

  @Override
  public Optional<Places> getByThemes(Themes themes) {
    Assert.notNull("themes", themes);

    List<Place> list = places.values().stream().filter(place -> place.themes().equals(themes)).toList();

    return Optional.of(new Places(list));
  }

  @Override
  public void save(Place place) {
    Assert.notNull("place", place);

    places.put(place.id(), place);
  }

  @Override
  public Optional<Place> get(PlaceId placeId) {
    Assert.notNull("placeId", placeId);

    return Optional.ofNullable(places.get(placeId));
  }
}
