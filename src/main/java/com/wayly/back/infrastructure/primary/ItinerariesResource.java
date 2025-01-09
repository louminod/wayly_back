package com.wayly.back.infrastructure.primary;

import com.wayly.back.application.ItinerariesApplicationService;
import com.wayly.back.domain.Theme;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/itineraries")
@Tag(name = "Itineraries", description = "Itineraries management")
public class ItinerariesResource {

  private final ItinerariesApplicationService itineraries;

  public ItinerariesResource(ItinerariesApplicationService itineraries) {
    this.itineraries = itineraries;
  }

  @GetMapping
  @Operation(summary = "Create an itinerary", description = "Create an itinerary based on themes")
  public ResponseEntity<RestItinerary> getItinerary(@RequestParam("themes") Collection<Theme> themes) {
    return ResponseEntity.ok(RestItinerary.from(itineraries.generate(themes)));
  }
}
