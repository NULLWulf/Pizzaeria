package PizzaPlus;

import java.io.Serializable;
import java.util.ArrayList;

public class Pizza implements Serializable {

    ArrayList<Toppings> toppings = new ArrayList<>();
    private double pizzaTotal;
    Customer customer;
    Toppings[] currToppings;
    double basePrice;
    XmlReader toppingsXml = new XmlReader("toppings.xml");

    static double pie12 = 12.00, pie14 = 14.00, pie16 = 16.00;


    public Pizza(double basePrice){
        this.basePrice = basePrice;
    }
    public void toppingsScroller(){
        currToppings = toppingsXml.getToppingsList();
        for (int i = 0; i < currToppings.length; i++){
            System.out.print("Topping - " + currToppings[i].getToppings() + ". Price per Servings $" + currToppings[i].getPriceforLarge()
            + ".\n");
        }

    }

    public void add(Toppings topping){
        toppings.add(topping);
        this.pizzaTotal = topping.getToppingPrice() + pizzaTotal;
    }

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
}
