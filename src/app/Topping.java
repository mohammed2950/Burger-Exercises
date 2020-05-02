package app;

/**
 * Topping
 */
public class Topping {

    private String name;
    private Double price;

    Topping(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.name + " : $" + String.format("%.2f", this.price) + "\n";
    }
}