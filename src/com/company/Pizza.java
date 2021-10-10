package com.company;

import java.util.ArrayList;

public class Pizza {

    final private ArrayList<Toppings> toppingsList;
    private double pizzaTotal;
    Customer customer;

    public Pizza(Customer customer){
        toppingsList = new ArrayList();
        this.customer = customer;
    }

    public double getPizzaTotal() {
        return pizzaTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setPizzaTotal(double pizzaTotal) {
        this.pizzaTotal = pizzaTotal;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void add(Toppings topping){
        toppingsList.add(topping);
        this.pizzaTotal = topping.getToppingPrice() + pizzaTotal;
    }

}
