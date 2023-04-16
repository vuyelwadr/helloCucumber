package hellocucumber;

import java.util.Arrays;
import java.util.LinkedList;

public class Shop {
    /**
     * Simple Shop-class with stock and shopping cart for testing simulation.
     *
     * Functions
     *                  getProductFromStock(ProductName)
     *                  addToCart(ProductName)
     *                  addToCart(ProductName, amount)
     *                  removeFromCart(ProductName, amount)
     *                  removeFromCart(ProductName)
     *                  isProductInCart(ProductName)
     *                  howManyInCart(ProductName)
     *                  howManyInCart()
     *                  howManyInStock(ProductName)
     *                  cartTotalPrice()
     *                  payCart(money)
     *
     *  Stock
     *  Name                    instock     price á
     *  Toilet Paper            10          3.99
     *  Minced meat             10          4.99
     *  Hand sanitizer          10          9.99
     *  Tuna                    10          1.60
     *  Egg                     10          0.20
     *
     *
     */
    LinkedList<Product> stock = new LinkedList<Product>(Arrays.asList(new Product("Toilet Paper", 10, 3.39),
            new Product("Minced meat", 10, 4.99), new Product("Hand sanitizer", 10, 9.99), new Product("Hand sanitizer", 10, 9.99), new Product("Tuna", 10, 1.60), new Product("Egg", 10, 0.20)));

    private LinkedList<Product> shoppingcart = new LinkedList<>();

    /**
     * Returns the shopping carts.
     * @return Shopping cart
     */
    public LinkedList<Product> getShoppingcart(){
        return this.shoppingcart;
    }

    /**
     * Returns the given product from stock.
     * @param p
     * @return
     */
    public Product getProductFromStock(String p){
        int i = 0;
        while(i < this.stock.size()){
            if(this.stock.get(i).getName().equals(p)){
                return this.stock.get(i);
            }
            i++;
        }
        return new Product("",0,0.00);
    }

    /**
     * Adds the given product to cart if there is enough in stock.
     * @param p Product Name
     * @param a Amount
     * @return String: on success "OK" otherwise "FAIL".
     */
    public String addToCart(String p, Integer a){
        int i = 0;
        while(i < this.stock.size()){
            if(this.stock.get(i).getName().equals(p) && this.stock.get(i).getStock()-a >= 0){
                for(int k = 0; k < a; k++){
                    this.shoppingcart.add(this.stock.get(i));
                }
                this.stock.get(i).reduceStock(a);
                return "OK";
            }
            i++;
        }
        return "FAIL";
    }
    public String addToCart(String p){
        int i = 0;
        while(i < this.stock.size()){
            if(this.stock.get(i).getName().equals(p) && this.stock.get(i).getStock()-1 >= 0){
                    this.shoppingcart.add(this.stock.get(i));
                this.stock.get(i).reduceStock(1);
                return "OK";
            }
            i++;
        }
        return "FAIL";
    }

    /**
     * Removes certain amount of products from the cart and returns them to stock.
     * @param p Product Name
     * @param a Amount
     * @return String: on success "OK" otherwise "FAIL"
     */
    public String removeFromCart(String p, Integer a){
        if(isProductInCart(p).equals("OK") && howManyInCart(p) >= a) {
            int i = 0;
            while (i < a) {
                if(removeFromCart(p).equals("OK")){
                    i++;
                    continue;
                }
                break;
            }
            return "OK";
        }
        return "FAIL";
    }
    /**
     * Removes product from cart and returns it to stock.
     * @param p Product Name
     * @return String: on success "OK" otherwise "FAIL"
     */
    public String removeFromCart(String p) {
        if (isProductInCart(p).equals("OK")) {
            int i = 0;
            while (i < shoppingcart.size()) {
                if (shoppingcart.get(i).getName().equals(p)) {
                    shoppingcart.get(i).increaseStock(1);
                    shoppingcart.remove(i);
                    return "OK";
                }
                i++;
            }
        }
        return "FAIL";
    }

    /**
     * Is the given product in the cart.
     * @param p Product Name
     * @return String: on success "OK" otherwise "FAIL"
     */
    public String isProductInCart(String p){
        int i = 0;
        while(i < shoppingcart.size()) {
            if (shoppingcart.get(i).getName().equals(p)) {
                return "OK";
            }
            i++;
        }
        return "FAIL";
    }

    /**
     * Total amount of the given product in cart.
     * @param p Product Name
     * @return Integer
     */
    public Integer howManyInCart(String p){
        Integer a = 0;
        int i = 0;
        while(i < shoppingcart.size()) {
            if (shoppingcart.get(i).getName().equals(p)) {
                a++;
            }
            i++;
        }
        return a;
    }

    /**
     * Total amount of products in cart.
     * @return Integer
     */
    public Integer howManyInCart(){
        return shoppingcart.size();
    }

    /**
     * Total amount of the given product in stock.
     * @param p Product Name
     * @return Integer
     */
    public Integer howManyInStock(String p){

        int i = 0;
        while(i < this.stock.size()) {
            if (this.stock.get(i).getName().equals(p)) {
                return this.stock.get(i).getStock();
            }
            i++;
        }
        return 0;
    }

    /**
     * Total price of the products in the cart.
     * @return Double
     */
    public Double cartTotalPrice(){
        int i = 0;
        Double total = 0.0;
        while(i < shoppingcart.size()) {
            total += shoppingcart.get(i).getPrice();
            i++;
        }
        return total;
    }

    /**
     * Pay the shopping cart. Clears cart if enough money.
     * @param money Double
     * @return String: on success "OK" otherwise "FAIL"
     */
    public String payCart(Double money){
        if(howManyInCart()==0) return "FAIL";
        if(money >= cartTotalPrice()) {
            shoppingcart.clear();
            return "OK";
        }
        return "FAIL";
    }
}

