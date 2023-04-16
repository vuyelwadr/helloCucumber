package hellocucumber;

public class Product {
    /**
     * Simple Product-class for for testing simulation.
     */

    private String name;
    private Integer instock;
    private Double price;

    Product (String n, Integer i, Double d){
        this.name = n;
        this.instock = i;
        this.price = d;
    }
    public String getName(){
        return this.name;
    }
    public Integer getStock(){
        return instock;
    }

    public double getPrice(){
        return this.price;
    }

    /**
     * Reduces products in stock
     * @param i amount
     * @return String: on success "OK" otherwise "FAIL".
     */
    public String reduceStock(Integer i){
        if(this.instock-i >= 0){
            this.instock -= i;
            return "OK";
        }
        return "FAIL";
    }

    /**
     * Increases product's stock by i
     * @param i amount
     */
    public void increaseStock(Integer i){
        this.instock += i;
    }
}

