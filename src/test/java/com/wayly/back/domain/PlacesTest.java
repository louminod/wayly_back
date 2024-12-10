package com.wayly.back.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.wayly.back.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
public class PlacesTest {

  @Test
  void shouldReturnPlacesTheme() {
    Places places = PlacesFixture.placesWithSameThemes;

    assertThat(places.themes().values()).containsExactlyInAnyOrderElementsOf(ThemesFixture.themes.values());
  }
}
