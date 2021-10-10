package com.company;

import java.util.ArrayList;

public class Pizza {

    ArrayList<Toppings> toppings = new ArrayList<Toppings>();
    private double pizzaTotal;
    Customer customer;

    public Pizza(Customer customer){this.customer = customer;}

    public double getPizzaTotal() {return pizzaTotal;}
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
        toppings.add(topping);
        this.pizzaTotal = topping.getToppingPrice() + pizzaTotal;
    }

}
