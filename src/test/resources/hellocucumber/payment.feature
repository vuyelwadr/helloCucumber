Feature: Paying for items in the shopping cart
    As a customer
    I want to be able to pay for all my items in the shopping cart
    So that I can complete my oder

    Scenario: Paying for items in the shopping cart
        Given The customer has added products to the shopping cart
        When The customer pays with the total amount to pay in the shopping cart
        Then The shopping cart should be emptied

    Scenario: Paying for items in the shopping cart without enough money
        Given The customer has added products to the shopping cart
        When The customer pays with an amount less than the total shopping cart amount
        Then The shopping cart should not be emptied
