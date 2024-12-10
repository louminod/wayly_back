package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public record Places(Collection<Place> values) {
  public Places {
    Assert.notNull("places", values);
  }

  public Themes themes() {
    Set<String> themes = values.stream().flatMap(place -> place.themes().values().stream()).collect(Collectors.toSet());
    return new Themes(new ArrayList<>(themes));
  }
}
