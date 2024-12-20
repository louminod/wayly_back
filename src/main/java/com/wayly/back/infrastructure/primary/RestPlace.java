package com.wayly.back.infrastructure.primary;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.wayly.back.domain.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@JsonDeserialize(builder = RestPlace.RestPlaceBuilder.class)
@Schema(name = "Place", description = "A Place")
public class RestPlace {

  private final String name;
  private final String description;

  private RestPlace(RestPlaceBuilder builder) {
    this.name = builder.name;
    this.description = builder.description;
  }

  Place toDomain() {
    return new Place(
      PlaceId.newId(),
      name,
      description,
      new Address("", "", "", "", "", new Coordinates(1.0, 2.0)),
      new Themes(List.of("Theme 1", "Theme 2"))
    );
  }

  public static RestPlace from(Place place) {
    return new RestPlaceBuilder().name(place.name()).build();
  }

  @JsonPOJOBuilder(withPrefix = "")
  static class RestPlaceBuilder {

    private String name;
    private String description;

    RestPlaceBuilder name(String name) {
      this.name = name;
      return this;
    }

    RestPlaceBuilder description(String description) {
      this.description = description;
      return this;
    }

    RestPlace build() {
      return new RestPlace(this);
    }
  }
}
