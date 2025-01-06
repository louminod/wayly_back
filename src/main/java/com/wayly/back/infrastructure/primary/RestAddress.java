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

  public static RestAddress from(Address address) {
    return new RestAddress(
      address.street(),
      address.city(),
      address.region(),
      address.country(),
      address.zipCode(),
      RestCoordinates.from(address.coordinates())
    );
  }

  @Schema(description = "Street of this address", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getStreet() {
    return street;
  }

  @Schema(description = "City of this address", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getCity() {
    return city;
  }

  @Schema(description = "Region of this address", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getRegion() {
    return region;
  }

  @Schema(description = "Country of this address", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getCountry() {
    return country;
  }

  @Schema(description = "Zip code of this address", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getZipCode() {
    return zipCode;
  }

  @Schema(description = "Coordinates of this address", requiredMode = Schema.RequiredMode.REQUIRED)
  public RestCoordinates getCoordinates() {
    return coordinates;
  }

  public Address toDomain() {
    return new Address(street, city, region, country, zipCode, coordinates.toDomain());
  }
}
