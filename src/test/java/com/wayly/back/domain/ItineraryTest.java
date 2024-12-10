package com.wayly.back.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.wayly.back.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
public class ItineraryTest {

  @Test
  void shouldHavePlacesNotNull() {
    Itinerary itinerary = new Itinerary.Builder().places(PlacesFixture.placesWithDifferentThemes).build();

    assertThat(itinerary.places()).isNotNull();
  }

  @Test
  void shouldHaveThemesContainingAllThemesFromPlaces() {
    Itinerary itinerary = new Itinerary.Builder().places(PlacesFixture.placesWithSameThemes).build();

    assertThat(itinerary.themes().values()).containsAll(ThemesFixture.themes.values());
  }
}
