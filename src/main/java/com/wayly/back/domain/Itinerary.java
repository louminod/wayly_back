package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public record Itinerary(Collection<Place> places) {
  public Itinerary {
    Assert.notNull("places", places);
  }

  public Collection<Theme> themes() {
    var themes = new HashSet<Theme>();
    for (var place : places) {
      themes.addAll(place.themes());
    }
    return Collections.unmodifiableCollection(themes);
  }

  public static class Builder {

    private Collection<Place> places;

    public Builder places(Collection<Place> places) {
      this.places = places;
      return this;
    }

    public Itinerary build() {
      return new Itinerary(places);
    }
  }
}
