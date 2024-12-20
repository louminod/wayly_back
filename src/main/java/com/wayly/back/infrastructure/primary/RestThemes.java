package com.wayly.back.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wayly.back.domain.Themes;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Collection;

@Schema(name = "Themes", description = "Themes of a place")
public class RestThemes {

  private final Collection<String> themes;

  public RestThemes(@JsonProperty("themes") Collection<String> themes) {
    this.themes = themes;
  }

  public Themes toDomain() {
    return new Themes(themes);
  }
}
