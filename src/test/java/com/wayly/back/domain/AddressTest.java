package com.wayly.back.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.wayly.back.UnitTest;
import com.wayly.back.shared.error.domain.MissingMandatoryValueException;
import org.junit.jupiter.api.Test;

@UnitTest
public class AddressTest {

  @Test
  public void shouldInstantiate() {
    Address address = new Address("My Street", "My City", "My Region", "My Country", "My Zip Code", new Coordinates(1.0, 2.0));

    assertThat(address.street()).isEqualTo("My Street");
    assertThat(address.city()).isEqualTo("My City");
    assertThat(address.region()).isEqualTo("My Region");
    assertThat(address.country()).isEqualTo("My Country");
    assertThat(address.zipCode()).isEqualTo("My Zip Code");
    assertThat(address.coordinate()).isEqualTo(new Coordinates(1.0, 2.0));
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullStreet() {
    assertThatThrownBy(() -> new Address(null, "My City", "My Region", "My Country", "My Zip Code", new Coordinates(1.0, 2.0)))
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("street");
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullCity() {
    assertThatThrownBy(() -> new Address("My Street", null, "My Region", "My Country", "My Zip Code", new Coordinates(1.0, 2.0)))
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("city");
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullRegion() {
    assertThatThrownBy(() -> new Address("My Street", "My City", null, "My Country", "My Zip Code", new Coordinates(1.0, 2.0)))
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("region");
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullCountry() {
    assertThatThrownBy(() -> new Address("My Street", "My City", "My Region", null, "My Zip Code", new Coordinates(1.0, 2.0)))
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("country");
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullZipCode() {
    assertThatThrownBy(() -> new Address("My Street", "My City", "My Region", "My Country", null, new Coordinates(1.0, 2.0)))
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("zipCode");
  }

  @Test
  public void shouldThrowAnExceptionWhenInstantiatedWithANullCoordinate() {
    assertThatThrownBy(() -> new Address("My Street", "My City", "My Region", "My Country", "My Zip Code", null))
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("coordinate");
  }
}
