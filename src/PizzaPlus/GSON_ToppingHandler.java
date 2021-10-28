package PizzaPlus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GSON_ToppingHandler {

    String jsonString = "";

        public Toppings readJSON() throws FileNotFoundException {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("toppings.json"));

            Toppings toppings = gson.fromJson(bufferedReader, Toppings.class);
            return toppings;
        }
    public void outputToppings(){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Toppings topping = gson.fromJson(jsonString, Toppings.class);
    }

}
