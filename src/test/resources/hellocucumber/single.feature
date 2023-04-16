Feature: Adding a Product to Shopping Cart
  As a customer
  I want to order a product and add it to the shopping cart one by one
  So that I can purchase the products I need

  Scenario: Add a product to the shopping cart
    Given The customer is on the product page
    When The customer clicks on the "Add to Cart" button for a product
    Then the product should be added to the shopping cart

  Scenario: Remove a product from the shopping cart
    Given The customer has added a product to the shopping cart
    When The customer removes the product from the shopping cart
    Then the product should no longer be in the shopping cart
