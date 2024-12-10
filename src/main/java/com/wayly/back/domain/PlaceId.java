package com.wayly.back.domain;

import java.util.UUID;

public record PlaceId(UUID value) {
  public static PlaceId newId() {
    return new PlaceId(UUID.randomUUID());
  }
}
