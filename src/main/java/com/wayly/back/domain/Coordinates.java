package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;

public record Coordinates(Double latitude, Double longitude) {
  public Coordinates {
    Assert.notNull("latitude", latitude);
    Assert.notNull("longitude", longitude);
  }
}
