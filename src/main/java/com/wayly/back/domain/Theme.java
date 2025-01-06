package com.wayly.back.domain;

import com.wayly.back.shared.error.domain.Assert;

public record Theme(String value) {
  public Theme {
    Assert.notNull("value", value);
  }
}
