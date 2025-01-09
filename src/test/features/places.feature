Feature: Places management

  Background:
    Given I have places
      | Name | Description | Street   | City  | Region  | Country  | Zip code | Latitude | Longitude | Themes         |
      | A    | Desc A      | Street A | CityA | RegionA | CountryA | 12345    | 45.75    | 4.85      | Theme1, Theme2 |
      | B    | Desc B      | Street B | CityB | RegionB | CountryB | 67890    | 45.76    | 4.86      | Theme2         |
      | C    | Desc C      | Street C | CityC | RegionC | CountryC | 11223    | 45.77    | 4.87      | Theme1         |

  Scenario: Should get place by name
    When I look for place with the name "A"
    Then I should have place
      | Name                          | A                   |
      | Description                   | Desc A              |
      | Address.Street                | Street A            |
      | Address.City                  | CityA               |
      | Address.Region                | RegionA             |
      | Address.Country               | CountryA            |
      | Address.Zip code              | 12345               |
      | Address.Coordinates.Latitude  | 45.75               |
      | Address.Coordinates.Longitude | 4.85                |
      | Themes                        | ["Theme1","Theme2"] |

  Scenario: Should get places by themes
    When I get places with theme "Theme1"
    Then I should have places
      | Name | Description | Address.Street | Address.City | Address.Region | Address.Country | Address.Zip code | Address.Coordinates.Latitude | Address.Coordinates.Longitude | Themes              |
      | A    | Desc A      | Street A       | CityA        | RegionA        | CountryA        | 12345            | 45.75                        | 4.85                          | ["Theme1","Theme2"] |
      | C    | Desc C      | Street C       | CityC        | RegionC        | CountryC        | 11223            | 45.77                        | 4.87                          | ["Theme1"]          |

  Scenario: Should get all places
    When I get all places
    Then I should have places
      | Name | Description | Address.Street | Address.City | Address.Region | Address.Country | Address.Zip code | Address.Coordinates.Latitude | Address.Coordinates.Longitude | Themes              |
      | A    | Desc A      | Street A       | CityA        | RegionA        | CountryA        | 12345            | 45.75                        | 4.85                          | ["Theme1","Theme2"] |
      | B    | Desc B      | Street B       | CityB        | RegionB        | CountryB        | 67890            | 45.76                        | 4.86                          | ["Theme2"]          |
      | C    | Desc C      | Street C       | CityC        | RegionC        | CountryC        | 11223            | 45.77                        | 4.87                          | ["Theme1"]          |

  Scenario: Should get places by city
    When I get places with city "CityA"
    Then I should have places
      | Name | Description | Address.Street | Address.City | Address.Region | Address.Country | Address.Zip code | Address.Coordinates.Latitude | Address.Coordinates.Longitude | Themes              |
      | A    | Desc A      | Street A       | CityA        | RegionA        | CountryA        | 12345            | 45.75                        | 4.85                          | ["Theme1","Theme2"] |
