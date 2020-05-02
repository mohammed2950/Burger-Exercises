package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Restaurant
 */
public class Restaurant {

    private static Scanner input;

    private static ArrayList<Burger> allBurgers = new ArrayList<>();
    private static Burger selectedBurger;
    private static ArrayList<Topping> selectedToppings = new ArrayList<>();

    Restaurant() {
        Burger basicBurger = new BasicBurger();
        Burger healthyBurger = new HealthyBurger();
        Burger deluxeBurger = new DeluxeBurger();

        Topping tomato = new Topping("Tomato", 0.27);
        Topping lettuce = new Topping("Lettuce", 0.72);
        Topping cheese = new Topping("Cheese", 1.13);
        Topping carrot = new Topping("Carrot", 2.75);
        Topping egg = new Topping("Egg", 5.12);
        Topping lentils = new Topping("Lentils", 3.14);
        Topping paneer = new Topping("Paneer", 3.55);
        Topping corn = new Topping("Corn", 1.81);

        ArrayList<Topping> basicToppings = new ArrayList<>();
        ArrayList<Topping> healthyToppings = new ArrayList<>();
        ArrayList<Topping> deluxeToppings = new ArrayList<>();

        basicToppings.add(tomato);
        basicToppings.add(lettuce);
        basicToppings.add(cheese);
        basicToppings.add(carrot);

        healthyToppings.addAll(basicToppings);
        healthyToppings.add(egg);
        healthyToppings.add(lentils);

        deluxeToppings.add(paneer);
        deluxeToppings.add(corn);

        basicBurger.setToppings(basicToppings);
        healthyBurger.setToppings(healthyToppings);
        deluxeBurger.setToppings(deluxeToppings);

        allBurgers.add(basicBurger);
        allBurgers.add(healthyBurger);
        allBurgers.add(deluxeBurger);

    }

    public static void displayBurgers() {

        System.out.println("\n\t\t Brampton Burgers");
        System.out.println("\n\t\t ````````````````");
        System.out.println("\t----------------------------------------");

        int i = 1;
        for (Burger burger : allBurgers) {
            System.out.println(i + ".\t" + burger);
            i++;
        }

        System.out.println("\t----------------------------------------");

    }

    public static void selectBurger() {
        System.out.print("Select: ");

        try {
            input = new Scanner(System.in);

            int choice = input.nextInt();

            if (choice > 3 || choice < 1) {
                System.out.println("Please select the correct Burger");
                selectBurger();
            } else {
                selectedBurger = allBurgers.get(choice - 1);
                System.out.println(selectedBurger);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Please select the correct Burger");
            selectBurger();
        }

    }

    public static void displayToppings() {

        System.out.println("\n ```````````````````````");
        System.out.println(" Please add some toppings");
        System.out.println("--------------------------\n");

        int i = 1;
        for (Topping topping : selectedBurger.getToppings()) {
            System.out.println(i + ".\t" + topping);
            i++;
        }

        System.out.println("0. \tThats All\n");

    }

    public static void chooseToppings() {
        System.out.println("\nchoose any " + selectedBurger.getMaxTopping() + " toppings : ");

        try {
            input = new Scanner(System.in);

            int choice = input.nextInt();

            if (choice == 0) {
                return;
            } else if (choice > selectedBurger.getMaxTopping()) {
                System.out.println("Please choose the topping from the list.");
                chooseToppings();
            } else {
                selectedToppings.add(selectedBurger.getToppings().get(choice - 1));
            }

        } catch (Exception e) {
            System.out.println("Please choose the topping from the list.");
            chooseToppings();
            // TODO: handle exception
        }

        if (selectedToppings.size() != selectedBurger.getMaxTopping()) {
            chooseToppings();
        }

    }

    public static void generateBill() {
        Bill bill = new Bill(selectedBurger, selectedToppings);
    }

}