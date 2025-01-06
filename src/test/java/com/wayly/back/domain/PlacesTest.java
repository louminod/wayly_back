package com.wayly.back.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.wayly.back.UnitTest;
import java.util.Collection;
import org.junit.jupiter.api.Test;

@UnitTest
public class PlacesTest {

  @Test
  void shouldReturnPlacesTheme() {
    Collection<Place> places = PlacesFixture.placesWithSameThemes();

    assertThat(places.stream().map(Place::themes).toList()).contains(ThemesFixture.themes());
  }
}
