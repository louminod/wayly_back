package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;
import java.util.ArrayList;
import java.util.HashSet;

public record Itinerary(Places places) {
  public Itinerary {
    Assert.notNull("places", places);
  }

  public Themes themes() {
    var themes = new HashSet<String>();
    for (var place : places.values()) {
      themes.addAll(place.themes().values());
    }
    return new Themes(new ArrayList<>(themes));
  }

  public static class Builder {

    private Places places;

    public Builder places(Places places) {
      this.places = places;
      return this;
    }

    public Itinerary build() {
      return new Itinerary(places);
    }
  }
}
