Feature: Itineraries generation

  Background:
    Given I have places
      | Name | Themes         |
      | A    | Theme1, Theme2 |
      | B    | Theme2         |
      | C    | Theme1         |

  Scenario: Should generate itinerary
    When I generate itinerary with themes "Theme1"
    Then I should have itinerary places
      | Place |
      | A     |
      | C     |
