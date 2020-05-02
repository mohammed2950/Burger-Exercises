package app;

import java.util.ArrayList;

/**
 * Burger
 */
public class Burger {
    private Double price;
    private String name;
    private String roll;
    private String meat;
    private Integer maxTopping;

    ArrayList<Topping> toppings = new ArrayList<>();

    public Burger(String name, Double price, String roll, String meat, Integer maxTopping) {
        this.name = name;
        this.price = price;
        this.roll = roll;
        this.meat = meat;
        this.maxTopping = maxTopping;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getRoll() {
        return this.roll;
    }

    public String getMeat() {
        return this.meat;
    }

    public Integer getMaxTopping() {
        return this.maxTopping;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings.addAll(toppings);
    }

    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    @Override
    public String toString() {
        return this.name + " with " + this.meat + " with " + this.roll + "\n\tCost: $"
                + String.format("%.2f", this.price) + "\n\tMaximum Toppings: " + this.maxTopping + "\n";
    }

}