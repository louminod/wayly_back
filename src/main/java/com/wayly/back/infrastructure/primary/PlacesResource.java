package com.wayly.back.infrastructure.primary;

import com.wayly.back.application.PlacesApplicationService;
import com.wayly.back.domain.Place;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/places")
@Tag(name = "Places", description = "Places management")
public class PlacesResource {

  private final PlacesApplicationService places;

  public PlacesResource(PlacesApplicationService places) {
    this.places = places;
  }

  @PostMapping
  @Operation(summary = "Create a place")
  public ResponseEntity<Collection<RestPlace>> createPlace(@Validated @RequestBody RestPlacesToCreate placesToCreate) {
    Collection<Place> places = this.places.create(placesToCreate.toDomain());
    return new ResponseEntity<>(places.stream().map(RestPlace::from).toList(), HttpStatus.CREATED);
  }
}
