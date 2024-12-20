package com.wayly.back.infrastructure.primary;

import static com.wayly.back.cucumber.rest.CucumberRestAssertions.assertThatLastResponse;

import com.wayly.back.cucumber.rest.CucumberRestTemplate;
import com.wayly.back.cucumber.rest.CucumberRestTestContext;
import io.cucumber.java.de.Wenn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class ItinerariesSteps {

  @Autowired
  private CucumberRestTemplate rest;

  private static final String PLACE_CREATION_TEMPLATE =
    """
    {
      "name": "{NAME}",
      "description": "{DESCRIPTION}",
      "address": {
        "street": "{STREET}",
        "city": "{CITY}",
        "region": "{REGION}",
        "country": "{COUNTRY}",
        "zipCode": "{ZIP_CODE}",
        "coordinate": {
          "latitude": {LATITUDE},
          "longitude": {LONGITUDE}
        }
      },
      "themes": [{THEMES}]
    }
    """;

  @Given("I have places")
  public void createPlaces(List<Map<String, String>> places) {
    rest.post("/api/places", buildPayload(places));

    assertThatLastResponse().hasHttpStatus(HttpStatus.CREATED);
  }

  @When("I generate itinerary with themes {string}")
  public void generateItinerary(String themes) {
    rest.get("/api/itineraries?themes=" + themes);

    assertThatLastResponse().hasOkStatus();
  }

  @Then("I should have itinerary places")
  public void shouldHaveItineraryPlaces(List<Map<String, String>> places) {
    assertThatLastResponse().hasOkStatus().hasElement("$.places").containing(places);
  }

  private String buildPayload(List<Map<String, String>> places) {
    return places.stream().map(toPlacePayload()).collect(Collectors.joining(",", placeCreationHeader(), "]}"));
  }

  private String placeCreationHeader() {
    return "{" + "\"places\":[";
  }

  private Function<Map<String, String>, String> toPlacePayload() {
    return place ->
      PLACE_CREATION_TEMPLATE.replace("{NAME}", place.getOrDefault("Name", "Place"))
        .replace("{DESCRIPTION}", place.getOrDefault("Description", "Description"))
        .replace("{STREET}", place.getOrDefault("Street", "99 Rue d'ici"))
        .replace("{CITY}", place.getOrDefault("City", "Lyon"))
        .replace("{REGION}", place.getOrDefault("Region", "Auvergne-Rhône-Alpes"))
        .replace("{COUNTRY}", place.getOrDefault("Country", "France"))
        .replace("{ZIP_CODE}", place.getOrDefault("Zip code", "69000"))
        .replace("{LATITUDE}", place.getOrDefault("Latitude", "45.75"))
        .replace("{LONGITUDE}", place.getOrDefault("Longitude", "4.85"))
        .replace("{THEMES}", "\"" + place.getOrDefault("Themes", "").replace(" ", "").replace(",", "\",\"") + "\"");
  }
}
