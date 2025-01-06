package com.wayly.back.infrastructure.primary;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.wayly.back.domain.*;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;

@JsonDeserialize(builder = RestPlace.RestPlaceBuilder.class)
@Schema(name = "Place", description = "A Place")
public class RestPlace {

  private final String name;
  private final String description;
  private final Collection<String> themes;
  private final RestAddress address;

  private RestPlace(RestPlaceBuilder builder) {
    this.name = builder.name;
    this.description = builder.description;
    this.themes = builder.themes;
    this.address = builder.address;
  }

  Place toDomain() {
    return new Place(PlaceId.newId(), name, description, address.toDomain(), themes.stream().map(Theme::new).toList());
  }

  public static RestPlace from(Place place) {
    return new RestPlaceBuilder()
      .name(place.name())
      .description(place.description())
      .address(RestAddress.from(place.address()))
      .themes(place.themes().stream().map(Theme::value).toList())
      .build();
  }

  @Schema(description = "Name of this place", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  @Schema(description = "Description of this place", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getDescription() {
    return description;
  }

  @Schema(description = "Themes of this place", requiredMode = Schema.RequiredMode.REQUIRED)
  public Collection<String> getThemes() {
    return themes;
  }

  @Schema(description = "Address of this place", requiredMode = Schema.RequiredMode.REQUIRED)
  public RestAddress getAddress() {
    return address;
  }

  @JsonPOJOBuilder(withPrefix = "")
  static class RestPlaceBuilder {

    private String name;
    private String description;
    private Collection<String> themes;
    private RestAddress address;

    RestPlaceBuilder name(String name) {
      this.name = name;
      return this;
    }

    RestPlaceBuilder description(String description) {
      this.description = description;
      return this;
    }

    RestPlaceBuilder themes(Collection<String> themes) {
      this.themes = themes;
      return this;
    }

    RestPlaceBuilder address(RestAddress address) {
      this.address = address;
      return this;
    }

    RestPlace build() {
      return new RestPlace(this);
    }
  }
}
