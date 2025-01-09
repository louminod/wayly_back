package com.wayly.back.infrastructure.primary;

import com.wayly.back.application.PlacesApplicationService;
import com.wayly.back.domain.Place;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collection;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping
  @Operation(summary = "Get places by name or themes")
  public ResponseEntity<?> getPlaces(
    @RequestParam(required = false) String name,
    @RequestParam(required = false) List<String> themes,
    @RequestParam(required = false) String city
  ) {
    if (name != null) {
      return new ResponseEntity<>(this.places.get(name).map(RestPlace::from).orElse(null), HttpStatus.OK);
    } else if (themes != null && !themes.isEmpty()) {
      return new ResponseEntity<>(this.places.getByThemes(themes).stream().map(RestPlace::from).toList(), HttpStatus.OK);
    } else if (city != null) {
      return new ResponseEntity<>(this.places.getByCity(city).stream().map(RestPlace::from).toList(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(this.places.getAll().stream().map(RestPlace::from).toList(), HttpStatus.OK);
    }
  }
}
