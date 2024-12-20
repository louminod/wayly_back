Feature: Itineraries generation

  Background:
    Given I have places
      | Name | Description | Street   | City  | Region  | Country  | Zip code | Latitude | Longitude | Themes         |
      | A    | Desc A      | Street A | CityA | RegionA | CountryA | 12345    | 45.75    | 4.85      | Theme1, Theme2 |
      | B    | Desc B      | Street B | CityB | RegionB | CountryB | 67890    | 45.76    | 4.86      | Theme2         |
      | C    | Desc C      | Street C | CityC | RegionC | CountryC | 11223    | 45.77    | 4.87      | Theme1         |

  Scenario: Should generate itinerary
    When I generate itinerary with themes "Theme1"
    Then I should have itinerary places
      | Name | Description | Street   | City  | Region  | Country  | Zip code | Latitude | Longitude | Themes         |
      | A    | Desc A      | Street A | CityA | RegionA | CountryA | 12345    | 45.75    | 4.85      | Theme1, Theme2 |
      | C    | Desc C      | Street C | CityC | RegionC | CountryC | 11223    | 45.77    | 4.87      | Theme1         |
