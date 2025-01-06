package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;
import java.util.Collection;

public record PlaceToCreate(String name, String description, Address address, Collection<Theme> themes) {
  public PlaceToCreate {
    Assert.notNull("name", name);
    Assert.notNull("description", description);
    Assert.notNull("address", address);
    Assert.notNull("themes", themes);
    Assert.notEmpty("themes", themes);
  }

  public Place create() {
    return new Place(PlaceId.newId(), name, description, address, themes);
  }
}
