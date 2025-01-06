package com.wayly.back.infrastructure.primary;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.wayly.back.domain.Itinerary;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;

@JsonDeserialize(builder = RestItinerary.RestItineraryBuilder.class)
@Schema(name = "Itinerary", description = "An itinerary")
public class RestItinerary {

  private final Collection<RestPlace> places;

  private RestItinerary(RestItineraryBuilder builder) {
    this.places = builder.places;
  }

  @Schema(name = "places", description = "Places")
  public Collection<RestPlace> getPlaces() {
    return places;
  }

  public static RestItinerary from(Itinerary itinerary) {
    return new RestItineraryBuilder().places(itinerary.places().stream().map(RestPlace::from).toList()).build();
  }

  @JsonPOJOBuilder(withPrefix = "")
  static class RestItineraryBuilder {

    private Collection<RestPlace> places;

    RestItineraryBuilder places(Collection<RestPlace> places) {
      this.places = places;
      return this;
    }

    RestItinerary build() {
      return new RestItinerary(this);
    }
  }
}
