package com.wayly.back.infrastructure.primary;

import com.wayly.back.domain.Coordinates;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Coordinates", description = "Coordinates")
public record RestCoordinates(double latitude, double longitude) {
  public static RestCoordinates from(Coordinates coordinates) {
    return new RestCoordinates(coordinates.latitude(), coordinates.longitude());
  }

  public Coordinates toDomain() {
    return new Coordinates(latitude, longitude);
  }

  @Override
  @Schema(description = "Latitude", requiredMode = Schema.RequiredMode.REQUIRED)
  public double latitude() {
    return latitude;
  }

  @Override
  @Schema(description = "Longitude", requiredMode = Schema.RequiredMode.REQUIRED)
  public double longitude() {
    return longitude;
  }
}
