package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;
import java.util.List;

public record Themes(List<String> values) {
  public Themes {
    Assert.notNull("values", values);
  }
}
