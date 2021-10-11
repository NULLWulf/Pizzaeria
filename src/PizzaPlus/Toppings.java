package PizzaPlus;

import java.io.Serializable;

public class Toppings implements Serializable {

    private String toppings;
    private String type;
    private double priceforSmall;
    private double priceforMedium;
    private double priceforLarge;
    private int quantityOunces;
    private double toppingPrice;

    public Toppings(String toppings, String type, double priceforSmall, double priceforMedium, double priceforLarge){
        this.toppings = toppings;
        this.type = type;
        this.priceforSmall = priceforSmall;
        this.priceforMedium = priceforMedium;
        this.priceforLarge = priceforLarge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPriceforSmall() {
        return priceforSmall;
    }

    public void setPriceforSmall(double priceforSmall) {
        this.priceforSmall = priceforSmall;
    }

    public double getPriceforMedium() {
        return priceforMedium;
    }

    public void setPriceforMedium(double priceforMedium) {
        this.priceforMedium = priceforMedium;
    }

    public double getPriceforLarge() {
        return priceforLarge;
    }

    public void setPriceforLarge(double priceforLarge) {
        this.priceforLarge = priceforLarge;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public String getToppings() {
        return toppings;
    }
    public int getQuantityOunces() {
        return quantityOunces;
    }
    public void setToppings(String toppings) {
        this.toppings = toppings;
    }
    public void setQuantityOunces(int quantityOunces) {
        this.quantityOunces = quantityOunces;
    }
}
