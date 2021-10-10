package com.company;
import java.util.Objects;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)  {
	// write your code here
        Scanner scanner = new Scanner(System.in);  // For general inputs
        Serializer serializer = new Serializer();  // initializes serializer
        Customer customer = serializer.objectReader();  // creates customer objects and attempts to import customer data into it, if any errors returns NULL
        Boolean runCondition = true;

        int selection;
        do{
            System.out.println("Welcome to Joe's Pizzeria");
            mainMenu();
            selection = validateInt();

            switch(selection){
                case 1 :
                    if (customer != null)
                    {
                        System.out.println("Warning, customer profile already made, overwrite? Y or N?");

                    }
                    else{  // Implies customer data successfully imported

                    }
                    break;
                case 2:
                    Pizza testPizza = new Pizza(customer);
                    Toppings pepperoni;
                    boolean toppingsFinished = false;
                    do{
                       testPizza.add(new Toppings(scanner.nextLine(), scanner.nextInt()));

                    }while(!toppingsFinished);
                    testPizza.add(new Toppings("Pepperoni", 5));

                    break;
                case 3:
                    break;
                default:
                    System.out.println("Exiting Program, goodbye!");
                    runCondition = false;
            }


        }while(runCondition);

    }

    public static void mainMenu(){
        System.out.println("1: Customer Profile Data");
        System.out.println("2: Place New Order");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static int validateInt(){
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        int number = 0;
        String strInput;

        while(!valid){
            System.out.println("Enter an integer value");
            strInput = in.nextLine();
            try{
                number = Integer.parseInt(strInput);
                valid = true;
            }catch(NumberFormatException e){
                System.out.println("Error, please integer an integer value");
            }
        }
        in.close();
        return number;
    }

}
