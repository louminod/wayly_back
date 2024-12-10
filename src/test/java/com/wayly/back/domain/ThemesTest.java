package com.wayly.back.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.wayly.back.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
public class ThemesTest {

  @Test
  void shouldGetThemes() {
    assertThat(ThemesFixture.themes).isEqualTo(ThemesFixture.themes);
  }

  @Test
  void shouldNotBeNull() {
    assertThat(ThemesFixture.themes).isNotNull();
  }
}
