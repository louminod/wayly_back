package com.wayly.back.domain;

import java.util.List;

public class ThemesFixture {

  private ThemesFixture() {}

  public static List<Theme> themes() {
    return List.of(new Theme("theme1"), new Theme("theme2"));
  }
}
