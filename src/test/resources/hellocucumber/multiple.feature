Feature: Adding a product in more quantities
  As a customer,
  I want to order a product in multiple quantities and add those to the shopping cart,
  So that I can purchase the products I need in the desired amount.

  Scenario: Add product with quantity
    Given The customer is on the product page
    And the product is in stock
    When The customer adds a quantity of 3 for the product to the cart
    Then the product with the selected quantity should be added to the shopping cart

  Scenario: Add product with zero quantity
    Given The customer is on the product page
    And the product is in stock
    When The customer adds a quantity of 0 for the product to the cart
    Then an error message should be displayed that the quantity should be more than 0
    And the product should not be added to the shopping cart

