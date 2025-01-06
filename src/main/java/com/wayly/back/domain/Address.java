package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;

public record Address(String street, String city, String region, String country, String zipCode, Coordinates coordinates) {
  public Address {
    Assert.notNull("street", street);
    Assert.notNull("city", city);
    Assert.notNull("region", region);
    Assert.notNull("country", country);
    Assert.notNull("zipCode", zipCode);
    Assert.notNull("coordinates", coordinates);
  }
}
