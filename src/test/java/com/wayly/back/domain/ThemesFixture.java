package com.wayly.back.domain;

import java.util.List;

public class ThemesFixture {

  private ThemesFixture() {}

  public static final List<String> themesValues = List.of("theme1", "theme2");

  public static final Themes themes = new Themes(themesValues);
}
