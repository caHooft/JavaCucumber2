#noinspection SpellCheckingInspection
Feature: Search and place orders for products

  Scenario: Search experience should be same in home and office page

    Given user is on Greencart landing page
    When  user searched with shortname "Tom" and finds actual name of the product
    Then  user searches for "Tom" shortname in offers space
    And   validate product name in offers page matches with Landing Page