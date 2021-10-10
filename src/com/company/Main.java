package com.company;
import java.util.Objects;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);  // For general inputs
        Serializer serializer = new Serializer();  // initializes serializer
        Customer customer = serializer.objectReader();  // creates customer objects and attempts to import customer data into it, if any errors returns NULL
        Boolean runCondition = true;  // when false program will terminate

        int selection;  // main input variable to menu navigation, will be expanded upon later
        do{
            System.out.println("Welcome to Joe's Pizzeria");
            if(customer == null){
                System.out.println("No customer information detected, please go to customer creation menu");
            }
            mainMenu();  // displays main menu
            selection = scanner.nextInt();

            switch(selection){  // main menu switch driver
                case 1 :
                    if(customer == null){   // When no customer profile data is detected defaults to new cust menu
                        System.out.println("No customer profile detected, launching new customer profile menu");
                        customer = new Customer();
                        customer.newCustomerMenu();
                        serializer.objectWriter(customer);
                    }
                    else {   // else displays defualt imported customer info
                        System.out.println("Displaying Customer Information");  // will seek out clenaer solution for this,
                        // probably built in class to display in customer menu
                        customer.displayCustomerInfo();
                        System.out.println("Enter 2 to return to main, 1 to over current customer data");
                        selection = scanner.nextInt();
                        if (selection == 1) {
                            System.out.println("Warning, customer profile already made, overwrite? 1 for Y or 2 for N?");
                            selection = scanner.nextInt();
                            if (selection == 1) {
                                System.out.println("Overwrite confirmed, Starting new customer menu");
                                customer = new Customer();
                                customer.newCustomerMenu();
                                serializer.objectWriter(customer);
                            } else {
                                System.out.println("Entry not confirmed, customer not over written");
                            }
                        }
                        else{

                                System.out.println("Exiting Customer Profile Menu");
                            }
                        }
                    // End Option Case 1 Block
                case 2:
//                    Pizza testPizza = new Pizza(customer);
//                    Toppings pepperoni;
//                    boolean toppingsFinished = false;
//                    do{
//                       testPizza.add(new Toppings(scanner.nextLine(), scanner.nextInt()));
//
//                    }while(!toppingsFinished);
//                    testPizza.add(new Toppings("Pepperoni", 5));
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
