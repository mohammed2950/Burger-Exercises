package app;

/**
 * BasicBurger
 */
public class BasicBurger extends Burger {
    BasicBurger() {
        super("Basic Burger", 3.56, "White", "Chicken", 4);
    }

    BasicBurger(String name, Double price, String roll, String meat, Integer maxTopping) {
        super(name, price, roll, meat, maxTopping);
    }
}