Feature: Query of the shopping cart
  As a customer
  I want to see a listing/content of the shopping cart I am about to buy
  So that I can review my order and make any necessary changes

  Scenario: View the shopping cart
    Given The customer has added products to the shopping cart
    When The customer clicks the shopping cart icon
    Then The customer should see the total number of items in the cart
    And The shopping cart should display the total amount for all products
