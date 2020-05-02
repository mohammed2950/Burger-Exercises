package app;

import java.util.ArrayList;

/**
 * Bill
 */
public class Bill {
    private double total = 0;
    private double tax = 0;
    private double netTotal = 0;

    public Bill(Burger burger, ArrayList<Topping> toppings) {
        calcTotal(burger, toppings);
        this.tax = this.total * 0.15;
        this.netTotal = this.total + this.tax;

        printReciept(burger, toppings);
    }

    private void printReciept(Burger burger, ArrayList<Topping> toppings) {
        System.out.println("\n\tReciept");
        System.out.println("\n\t```````");

        System.out.println("1. " + burger.getName() + " - " + burger.getPrice());

        if (toppings.size() > 0) {
            System.out.println("\nExtras: ");
            System.out.println("\n``````` ");
            int i = 1;
            for (Topping topping : toppings) {
                System.out.println(i + ". " + topping);
                i++;
            }
        } else {
            System.out.println("\nNo extra toppings");
        }

        System.out.println("\n-------------------------------");

        System.out.println("Amount : " + String.format("%.2f", this.total) + "$");
        System.out.print(" + (Tax : " + String.format("%.2f", this.tax) + "$)");
        System.out.println("\n--------------------------------");

        System.out.println("Total : " + String.format("%.2f", this.netTotal) + "$");
        System.out.println("------------------------------------");

    }

    private void calcTotal(Burger burger, ArrayList<Topping> toppings) {
        this.total += burger.getPrice();
        for (Topping topping : toppings) {
            this.total += topping.getPrice();
        }
    }
}