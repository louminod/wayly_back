package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;
import java.util.Collection;

public record Themes(Collection<String> values) {
  public Themes {
    Assert.notNull("values", values);
  }
}
