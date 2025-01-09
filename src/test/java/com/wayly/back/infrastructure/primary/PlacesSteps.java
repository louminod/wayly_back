package com.wayly.back.infrastructure.primary;

import static com.wayly.back.cucumber.rest.CucumberRestAssertions.assertThatLastResponse;

import com.wayly.back.cucumber.rest.CucumberRestTemplate;
import com.wayly.back.domain.PlacesRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class PlacesSteps {

  @Autowired
  private CucumberRestTemplate rest;

  @Autowired
  private PlacesRepository places;

  @When("I look for place with the name {string}")
  public void getPlace(String name) {
    rest.get("/api/places?name=" + name);

    assertThatLastResponse().hasOkStatus();
  }

  @Before
  public void clean() {
    places.deleteAll();
  }

  @Then("I should have place")
  public void shouldHavePlace(Map<String, String> place) {
    assertThatLastResponse().hasOkStatus().hasElement("$").containing(place);
  }

  @When("I get places with theme {string}")
  public void getPlacesWithThemes(String theme) {
    rest.get("/api/places?themes=" + theme);

    assertThatLastResponse().hasOkStatus();
  }

  @Then("I should have places")
  public void shouldHavePlaces(List<Map<String, String>> places) {
    assertThatLastResponse().hasOkStatus().hasElement("$").containing(places);
  }
}
