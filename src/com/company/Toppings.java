package com.company;

public class Toppings {

    private String toppings;
    private double price;
    private int quantityOunces;

    public Toppings(String toppings, int quantityOunces){
        this.toppings = toppings;
        this.quantityOunces = quantityOunces;
    }

    public double getToppingPrice(){
        return price * quantityOunces;
    }
    public String getToppings() {
        return toppings;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantityOunces() {
        return quantityOunces;
    }
    public void setToppings(String toppings) {
        this.toppings = toppings;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantityOunces(int quantityOunces) {
        this.quantityOunces = quantityOunces;
    }
}
