package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;

public class Customer implements Serializable {

    private double totalOrderPrice;
    final private ArrayList pizzasOrdered = new ArrayList();
    private String name;
    private String phoneNumber;
    String customerFile = "customer.ser";

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber= phoneNumber;

    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public void add(Pizza pizza){
        pizzasOrdered.add(pizza);
        this.totalOrderPrice = pizza.getPizzaTotal() + totalOrderPrice;
    }

}
