package hellocucumber;

import io.cucumber.java.en.*;

public class StepDefinitions {

    // private Product product;
    private Shop shop = new Shop();
    private Product rand = new Product("", 0, 0.00);

    @Given("The customer is on the product page")
    public void customerOnProductPage() {
        assert (!shop.getProductFromStock("Egg").equals(rand));
    }

    @When("The customer clicks on the \"Add to Cart\" button for a product")
    public void customerAddsProductToCart() {
        assert (shop.addToCart("Egg").equals("OK")); // add the product to the shopping cart
    }

    @Then("the product should be added to the shopping cart")
    public void productAddedToCart() {
        assert (shop.isProductInCart("Egg").equals("OK")); // check if product is in the shopping cart
    }

    @Given("The customer has added a product to the shopping cart")
    public void customerAddedProductToCart() {
        assert (shop.addToCart("Egg").equals("OK"));
    }

    @When("The customer removes the product from the shopping cart")
    public void customerRemovesProductFromCart() {
        assert (shop.removeFromCart("Egg").equals("OK")); // remove the product from the shopping cart
    }

    @Then("the product should no longer be in the shopping cart")
    public void productRemovedFromCart() {
        assert (shop.isProductInCart("Egg").equals("FAIL")); // check if product is not in the shopping cart
    }

    @And("the product is in stock")
    public void productInStock() {
        assert (shop.howManyInStock("Egg") >= 3);
    }

    @When("The customer adds a quantity of 3 for the product to the cart")
    public void customerAddsAQuantityOf3ForTheProduct() {
        assert (shop.addToCart("Egg", 3).equals("OK"));
    }

    @Then("the product with the selected quantity should be added to the shopping cart")
    public void theProductWithTheSelectedQuantityShouldBeAddedToTheShoppingCart() {
        assert (shop.howManyInCart("Egg").equals(3));
    }

    @When("The customer adds a quantity of 0 for the product to the cart")
    public void customerAdds0ProductToCart() {
        assert (shop.addToCart("Egg", 0).equals("OK")); // add the product to the shopping cart
    }

    @Then("an error message should be displayed that the quantity should be more than 0")
    public void product0Error() {
        assert (shop.isProductInCart("Egg").equals("FAIL")); // check if product is in the shopping cart
    }

    @And("the product should not be added to the shopping cart")
    public void productNotAddedToCart() {
        assert (shop.isProductInCart("Egg").equals("FAIL")); // check if product is in the shopping cart
    }

    @Given("The customer has added products to the shopping cart")
    public void customerAddedProductsToCart() {
        assert (shop.addToCart("Egg", 3).equals("OK"));
        assert (shop.addToCart("Tuna", 2).equals("OK"));
    }

    @When("The customer clicks the shopping cart icon")
    public void customerClicksShoppingCart() {
    }

    @Then("The customer should see the total number of items in the cart")
    public void totalNumberInCart() {
        assert (shop.howManyInCart().equals(5));
    }

    @And("The shopping cart should display the total amount for all products")
    public void totalAmountInCart() {
        assert (shop.cartTotalPrice() >= 3.80);
    }

    @When("The customer pays with the total amount to pay in the shopping cart")
    public void customerClicksPayShoppingCart() {
        assert (shop.payCart(shop.cartTotalPrice()).equals("OK"));
    }

    @And("The shopping cart should be emptied")
    public void emptyShoppingCart() {
        assert (shop.howManyInCart()).equals(0);
    }

    @When("The customer pays with an amount less than the total shopping cart amount")
    public void paysWithAmountLessThanCartTotal() {
        assert (shop.payCart(shop.cartTotalPrice() - 0.1).equals("FAIL"));
    }

    @And("The shopping cart should not be emptied")
    public void notEmptyShoppingCart() {
        assert !(shop.howManyInCart()).equals(0);
    }

    @Given("an example scenario")
    public void anExampleScenario() {
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
    }

}
