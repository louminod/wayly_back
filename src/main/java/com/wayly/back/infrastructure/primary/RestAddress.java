package com.wayly.back.infrastructure.primary;

import com.wayly.back.domain.Address;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Address", description = "An address")
public class RestAddress {

  private final String street;
  private final String city;
  private final String region;
  private final String country;
  private final String zipCode;
  private final RestCoordinates coordinates;

  public RestAddress(String street, String city, String region, String country, String zipCode, RestCoordinates coordinates) {
    this.street = street;
    this.city = city;
    this.region = region;
    this.country = country;
    this.zipCode = zipCode;
    this.coordinates = coordinates;
  }

  public Address toDomain() {
    return new Address(street, city, region, country, zipCode, coordinates.toDomain());
  }
}
