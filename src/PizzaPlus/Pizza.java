package PizzaPlus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    public void toppingsScroller() throws FileNotFoundException {
//        currToppings = toppingsXml.getToppingsList();

        List<Toppings> users = new Gson().fromJson(new FileReader("toppings.json"),new TypeToken<List<Toppings>>() {}.getType());
        users.forEach(System.out::println);
//        for (int i = 0; i < currToppings.length; i++){
//            System.out.print("Topping - " + currToppings[i].getToppings() + ". Price per Servings $" + currToppings[i].getPriceforLarge()
//            + ".\n");
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
