package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;
import java.util.Collection;

public record Place(PlaceId id, String name, String description, Address address, Collection<Theme> themes) {
  public Place {
    Assert.notNull("id", id);
    Assert.notNull("name", name);
    Assert.notNull("description", description);
    Assert.notNull("address", address);
    Assert.notNull("themes", themes);
    Assert.notEmpty("themes", themes);
  }
}
