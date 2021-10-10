package com.company;

import java.util.ArrayList;

public class Order {

    Customer customer;
    ArrayList<Pizza> itemsOrdered = new ArrayList<Pizza>();

    private double total;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Pizza[] getItems(){
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
    public double getTotal(){return this.total;}
}
