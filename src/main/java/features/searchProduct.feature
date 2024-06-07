Feature: Search and place orders for products

  Scenario: Search experience should be same in home and office page

    Given user is on greencart landing page
    When  user searched with shortname "Tom" and finds actual name of the product
    Then  user searches for the same product with the same shortname in office space