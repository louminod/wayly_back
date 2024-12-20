package com.wayly.back.infrastructure.primary;

import com.wayly.back.domain.Coordinates;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Coordinates", description = "Coordinates")
public class RestCoordinates {

  private final double latitude;
  private final double longitude;

  public RestCoordinates(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Coordinates toDomain() {
    return new Coordinates(latitude, longitude);
  }
}
