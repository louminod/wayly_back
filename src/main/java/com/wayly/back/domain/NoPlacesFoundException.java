package com.wayly.back.domain;

public class NoPlacesFoundException extends RuntimeException {

  public NoPlacesFoundException(String message) {
    super(message);
  }
}
