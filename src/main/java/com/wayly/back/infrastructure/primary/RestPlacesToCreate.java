package com.wayly.back.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wayly.back.domain.PlaceToCreate;
import com.wayly.back.domain.Places;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;

@Schema(name = "PlacesToCreate", description = "Informations to create places")
public class RestPlacesToCreate {

  private final Collection<RestPlace> places;

  RestPlacesToCreate(@JsonProperty("places") Collection<RestPlace> places) {
    this.places = places;
  }

  public Collection<PlaceToCreate> toDomain() {
    Places places = new Places(getPlaces().stream().map(RestPlace::toDomain).toList());

    return places
      .values()
      .stream()
      .map(place -> new PlaceToCreate(place.name(), place.description(), place.address(), place.themes()))
      .toList();
  }

  @Schema(description = "Places", requiredMode = Schema.RequiredMode.REQUIRED)
  public Collection<RestPlace> getPlaces() {
    return places;
  }
}
