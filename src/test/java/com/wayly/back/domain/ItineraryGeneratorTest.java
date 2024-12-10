package com.wayly.back.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;

import com.wayly.back.UnitTest;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@UnitTest
public class ItineraryGeneratorTest {

  @Mock
  private PlacesRepository placesRepository;

  @InjectMocks
  private ItineraryGenerator itineraryGenerator;

  @Test
  void shouldGenerateItineraryBasedOnDefinedThemes() {
    when(placesRepository.getByThemes(ThemesFixture.themes)).thenReturn(Optional.of(PlacesFixture.placesWithSameThemes));

    Itinerary itinerary = itineraryGenerator.generate(ThemesFixture.themes);

    assertThat(itinerary.places().values()).containsExactlyInAnyOrderElementsOf(PlacesFixture.placesWithSameThemes.values());
  }

  @Test
  void shouldThrowAnExceptionWhenNoPlacesAreFoundForDefinedThemes() {
    when(placesRepository.getByThemes(ThemesFixture.themes)).thenReturn(Optional.empty());

    assertThatThrownBy(() -> itineraryGenerator.generate(ThemesFixture.themes))
      .isInstanceOf(NoPlacesFoundException.class)
      .hasMessageContaining("No places found for themes");
  }
}
