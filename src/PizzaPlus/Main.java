package PizzaPlus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Main<toString> {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);  // For general inputs
        Serializer serializer = new Serializer();  // initializes serializer
        Customer customer = serializer.objectReader();  // creates customer objects and attempts to import customer data into it, if any errors returns NULL
        Boolean runCondition = true;  // when false program will terminate

        Writer writer = new FileWriter("customerData.json");
        Gson gson = new GsonBuilder().create();
        gson.toJson(customer, writer);
        writer.flush(); //flush data to file   <---
        writer.close(); //close write          <---


        int selection;  // main input variable to menu navigation, will be expanded upon later
        do{
            System.out.println("Welcome to Joe's Pizzeria");  // generaic welcome message
            if(customer == null){  // detects if customer is null and if so instructs customer to make profile
                System.out.println("No customer information detected, please go to customer creation menu");
            }
            mainMenu();  // displays main menu
            selection = scanner.nextInt();  // main menu selection

            switch(selection) {  // main menu switch driver
                case 1:
                    if (customer == null) {   // When no customer profile data is detected defaults to new cust menu
                        System.out.println("No customer profile detected, launching new customer profile menu");
                        customer = new Customer();  // if null customer construct new customer
                        customer.newCustomerMenu(); // opens internal customer menu
                        serializer.objectWriter(customer);  // writes new customer to file
                    } else {   // else displays defualt imported customer info
                        System.out.println("Displaying Customer Information");  // will seek out clenaer solution for this,
                        // probably built in class to display in customer menu
                        customer.displayCustomerInfo();  // displays customer info
                        System.out.println("Enter 2 to return to main, 1 to over current customer data");
                        selection = scanner.nextInt();
                        if (selection == 1) {  // over write customer function
                            System.out.println("Warning, customer profile already made, overwrite? 1 for Y or 2 for N?");
                            selection = scanner.nextInt();
                            if (selection == 1) { // confirmation for over write
                                System.out.println("Overwrite confirmed, Starting new customer menu");
                                customer = new Customer();
                                customer.newCustomerMenu();  // opens new customer menu for over writting
                                serializer.objectWriter(customer);  // this will over write customer.txt files assuming
                                // file was not change
                            } else {  // return to prior
                                System.out.println("Entry not confirmed, customer not over written");
                            }
                        } else {  // return to prior
                            System.out.println("Exiting Customer Profile Menu");
                        }
                    }
                    // End Option Case 1 Block for General Customer Menu
                    // Start Case 2 case block for ordering system
                case 2:
                    if (customer == null) {   // Same as function 1, serves as fail safe if new customer atempts to order regardless
                        System.out.println("No customer profile detected, launching new customer profile menu");
                        customer = new Customer();
                        customer.newCustomerMenu();
                        serializer.objectWriter(customer);  // basically does everything as above,
                        Order currentOrder = new Order(customer);  // initializes a current order
                        currentOrder.orderingSystem();  // opens internal ordering system for order class
                        if (currentOrder.isOrderVerified()) {  // if order is completed verified
                            customer.add(currentOrder);  // order will be added to customers order lists
                            // serializer.objectWriter(customer);  // and also be written to file
                        } else {  // total failure in ordering system, nothing is store, wrote to file etc.
                            System.out.println("Order not verified, please restart ordering system to order");
                        }
                    } else {  // if customer profile is already detecteed will not prompt new profile data
                        Order currentOrder = new Order(customer);
                        currentOrder.orderingSystem();  // opens internal ordering system
                        if (currentOrder.isOrderVerified()) {
                            customer.add(currentOrder);
                            // serializer.objectWriter(customer);  // same as above if verified will add and write to file
                        } else {  // otherwise will fail and nothing will be written
                            System.out.println("Order not verified, please restart ordering system to order");
                        }
                    }

//                    // End Option 2 case block
//
//
//                case 3:
//                    break;
//                default:
//                    System.out.println("Exiting Program, goodbye!");
//                    runCondition = false;
//            }
            }
        }while(true);
    }



    public static void mainMenu(){
        System.out.println("1: Customer Profile Data");
        System.out.println("2: Place New Order");
        System.out.println("Any other key to exit");
//        System.out.println();
//        System.out.println();
    }

//    public static int validateInt(){
//        Scanner in = new Scanner(System.in);
//        boolean valid = false;
//        int number = 0;
//        int strInput;
//
//        while(!valid){
//            System.out.println("Enter an integer value");
//            strInput = in.nextInt();
//            try{
//                number = Integer.parseInt(String.valueOf(strInput));
//                valid = true;
//            }catch(NumberFormatException e){
//                System.out.println("Error, please integer an integer value");
//            }
//        }
//        in.close();
//        return number;
//    }

}
