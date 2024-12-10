package com.wayly.back.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.wayly.back.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
public class PlaceIdTest {

  @Test
  void shouldGenerateId() {
    assertThat(PlaceId.newId()).isNotNull().isNotEqualTo(PlaceId.newId());
  }
}
