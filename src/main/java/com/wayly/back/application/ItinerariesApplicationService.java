package com.wayly.back.application;

import com.wayly.back.domain.Itinerary;
import com.wayly.back.domain.ItineraryGenerator;
import com.wayly.back.domain.PlacesRepository;
import com.wayly.back.domain.Theme;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class ItinerariesApplicationService {

  private final ItineraryGenerator itineraryGenerator;

  public ItinerariesApplicationService(PlacesRepository places) {
    this.itineraryGenerator = new ItineraryGenerator(places);
  }

  public Itinerary generate(Collection<Theme> themes) {
    return itineraryGenerator.generate(themes);
  }
}
