package com.wayly.back.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.wayly.back.UnitTest;
import com.wayly.back.shared.error.domain.MissingMandatoryValueException;
import org.junit.jupiter.api.Test;

@UnitTest
public class CoordinatesTest {

  @Test
  public void shouldInstantiate() {
    Coordinates coordinate = new Coordinates(1.0, 2.0);

    assertThat(coordinate.latitude()).isEqualTo(1.0);
    assertThat(coordinate.longitude()).isEqualTo(2.0);
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullLatitude() {
    assertThatThrownBy(() -> new Coordinates(null, 2.0))
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("latitude");
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullLongitude() {
    assertThatThrownBy(() -> new Coordinates(1.0, null))
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("longitude");
  }
}
