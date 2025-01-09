package com.wayly.back.domain;

public final class AddressesFixture {

  private AddressesFixture() {}

  public static Address address() {
    return new Address("street", "city", "region", "country", "zipCode", new Coordinates(1.0, 1.0));
  }
}
