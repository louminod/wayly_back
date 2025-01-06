package com.wayly.back.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.wayly.back.UnitTest;
import com.wayly.back.shared.error.domain.MissingMandatoryValueException;
import org.junit.jupiter.api.Test;

@UnitTest
public class PlaceTest {

  @Test
  public void shouldInstantiate() {
    Place place = new Place(
      PlacesFixture.placeId(),
      "My Place",
      "My Place Description",
      AddressesFixture.address(),
      ThemesFixture.themes()
    );

    assertThat(place.id()).isEqualTo(PlacesFixture.placeId());
    assertThat(place.name()).isEqualTo("My Place");
    assertThat(place.description()).isEqualTo("My Place Description");
    assertThat(place.address()).isEqualTo(AddressesFixture.address());
    assertThat(place.themes()).isEqualTo(ThemesFixture.themes());
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullId() {
    assertThatThrownBy(() ->
      new Place(
        null,
        "My Place",
        "My Place Description",
        new Address("My Street", "My City", "My Region", "My Country", "My  ZipCode", new Coordinates(0.0, 0.0)),
        ThemesFixture.themes()
      )
    )
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("id");
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullName() {
    assertThatThrownBy(() ->
      new Place(
        PlacesFixture.placeId(),
        null,
        "My Place Description",
        new Address("My Street", "My City", "My Region", "My Country", "My  ZipCode", new Coordinates(0.0, 0.0)),
        ThemesFixture.themes()
      )
    )
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("name");
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullDescription() {
    assertThatThrownBy(() ->
      new Place(
        PlacesFixture.placeId(),
        "My Place",
        null,
        new Address("My Street", "My City", "My Region", "My Country", "My  ZipCode", new Coordinates(0.0, 0.0)),
        ThemesFixture.themes()
      )
    )
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("description");
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullAddress() {
    assertThatThrownBy(() -> new Place(PlacesFixture.placeId(), "My Place", "My Place Description", null, ThemesFixture.themes()))
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("address");
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullThemes() {
    assertThatThrownBy(() ->
      new Place(
        PlacesFixture.placeId(),
        "My Place",
        "My Place Description",
        new Address("My Street", "My City", "My Region", "My Country", "My  ZipCode", new Coordinates(0.0, 0.0)),
        null
      )
    )
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("themes");
  }
}
