package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        new Restaurant();

        // Burger b = new Burger("Basic Burger", 3.56, "White", "Chicken", 4);

        Restaurant.displayBurgers();
        Restaurant.selectBurger();
        Restaurant.displayToppings();
        Restaurant.chooseToppings();
        Restaurant.generateBill();
    }

}