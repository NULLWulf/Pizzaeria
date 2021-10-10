package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    Customer customer;
    ArrayList<Pizza> itemsOrdered = new ArrayList<Pizza>();
    private boolean orderVerified;
    private double total;





    public Order(Customer customer) {
        this.customer = customer;
    }

    public Pizza[] getItems() {
        Pizza[] listArray = new Pizza[itemsOrdered.size()];
        listArray = (Pizza[]) itemsOrdered.toArray(listArray);
        return listArray;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addItem(Pizza pizza) {
        itemsOrdered.add(pizza);
        this.total = pizza.getPizzaTotal() + total;
    }

    public double getTotal() {
        return this.total;
    }

    public void orderingSystem() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ordering systems, currently we only have pizzas");
        boolean pizzaFinished = false;
        boolean orderFinished;  // maintains the multi ordering loop
        int selection;

            do {  // will stay in loop so long as user wishes to continue to add pizzas
                do {  // stays in loop while working currnet pizza
                    System.out.println("Select a Pizza size, 1 for 12, 2 for 14, 3 for 16.  Units are in inches");
                    selection = scanner.nextInt();  // grabs pizza size selection
                    Pizza currentPizza;
                    switch (selection) {  // select by available pizza sizes
                        case 1:
                            currentPizza = new Pizza(12);
                            break;
                        case 2:
                            currentPizza = new Pizza(14);
                            break;
                        case 3:
                            currentPizza = new Pizza(16);
                            break;
                        default:
                            currentPizza = null;  // needed to rid of erors, may swithc if to if else statement
                            // item ordering is not finalized as this time
                    }
                    System.out.println("Does this pizza look correct?");
                    System.out.println("Enter 1 to confirm, 2 to restart pizza");
                    selection = scanner.nextInt();
                    if (selection == 1) {  // if pizza is confirmed pizza will be added to arraylist of pizzas
                        // may also include other items down the road
                        pizzaFinished = true;
                        itemsOrdered.add(currentPizza);
                    }
                } while (!pizzaFinished);

                // Prompts to order additional pizzas, if not wanting to oder additional pizzas loop will break
                System.out.println("Order additional pizzas?");
                System.out.println("Enter 1 to confirm, 2 to go to checkout");
                selection = scanner.nextInt();
                if (selection  == 1){
                    orderFinished = false;
                }
                else{
                    orderFinished = true;
                }
            } while (!orderFinished);

            // Final verification of order process, if correct updates class variable to order verified for use in
            // main function, if not verified order will be completely cleared and user will have to restart
            // todo more elegants solutions on this
            System.out.println("Does this order look correct?");
            System.out.println("Press 1 to confirm, 2 to completely restart order");
            selection = scanner.nextInt();
            if (selection == 1){
                this.orderVerified = true;  // updates class varialbe to true for use in main function
            }
            else{
                itemsOrdered.clear();  // clears array of pizzas
                System.out.println("Order list completely restarted, please place order again");
                this.orderVerified = false;
            }

    }

    public boolean isOrderVerified() {
        return orderVerified;
    }

    public void setOrderVerified(boolean orderVerified) {
        this.orderVerified = orderVerified;
    }
}
