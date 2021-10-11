package PizzaPlus

import PizzaPlus.Customer.newCustomerMenu
import PizzaPlus.Customer.displayCustomerInfo
import PizzaPlus.Customer.add
import PizzaPlus.Customer.firstName
import PizzaPlus.Customer.lastName
import kotlin.jvm.JvmStatic
import PizzaPlus.Customer
import PizzaPlus.Order
import PizzaPlus.Pizza
import PizzaPlus.Toppings
import java.io.ObjectOutputStream
import java.io.FileOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.io.ObjectInputStream
import java.io.FileInputStream
import java.lang.ClassNotFoundException
import kotlin.Throws
import PizzaPlus.XmlHandler
import java.io.File
import java.util.*
import javax.xml.parsers.SAXParserFactory

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`) // For general inputs
        val serializer = Serializer() // initializes serializer
        var customer =
            serializer.objectReader() // creates customer objects and attempts to import customer data into it, if any errors returns NULL
        val runCondition = true // when false program will terminate
        var selection: Int // main input variable to menu navigation, will be expanded upon later
        do {
            println("Welcome to Joe's Pizzeria") // generaic welcome message
            if (customer == null) {  // detects if customer is null and if so instructs customer to make profile
                println("No customer information detected, please go to customer creation menu")
            }
            mainMenu() // displays main menu
            selection = scanner.nextInt() // main menu selection
            when (selection) {
                1 -> {
                    if (customer == null) {   // When no customer profile data is detected defaults to new cust menu
                        println("No customer profile detected, launching new customer profile menu")
                        customer = Customer() // if null customer construct new customer
                        customer.newCustomerMenu() // opens internal customer menu
                        serializer.objectWriter(customer) // writes new customer to file
                    } else {   // else displays defualt imported customer info
                        println("Displaying Customer Information") // will seek out clenaer solution for this,
                        // probably built in class to display in customer menu
                        customer.displayCustomerInfo() // displays customer info
                        println("Enter 2 to return to main, 1 to over current customer data")
                        selection = scanner.nextInt()
                        if (selection == 1) {  // over write customer function
                            println("Warning, customer profile already made, overwrite? 1 for Y or 2 for N?")
                            selection = scanner.nextInt()
                            if (selection == 1) { // confirmation for over write
                                println("Overwrite confirmed, Starting new customer menu")
                                customer = Customer()
                                customer.newCustomerMenu() // opens new customer menu for over writting
                                serializer.objectWriter(customer) // this will over write customer.txt files assuming
                                // file was not change
                            } else {  // return to prior
                                println("Entry not confirmed, customer not over written")
                            }
                        } else {  // return to prior
                            println("Exiting Customer Profile Menu")
                        }
                    }
                    if (customer == null) {   // Same as function 1, serves as fail safe if new customer atempts to order regardless
                        println("No customer profile detected, launching new customer profile menu")
                        customer = Customer()
                        customer.newCustomerMenu()
                        serializer.objectWriter(customer) // basically does everything as above,
                        val currentOrder = Order(customer) // initializes a current order
                        currentOrder.orderingSystem() // opens internal ordering system for order class
                        if (currentOrder.isOrderVerified) {  // if order is completed verified
                            customer.add(currentOrder) // order will be added to customers order lists
                            // serializer.objectWriter(customer);  // and also be written to file
                        } else {  // total failure in ordering system, nothing is store, wrote to file etc.
                            println("Order not verified, please restart ordering system to order")
                        }
                    } else {  // if customer profile is already detecteed will not prompt new profile data
                        val currentOrder = Order(customer)
                        currentOrder.orderingSystem() // opens internal ordering system
                        if (currentOrder.isOrderVerified) {
                            customer.add(currentOrder)
                            // serializer.objectWriter(customer);  // same as above if verified will add and write to file
                        } else {  // otherwise will fail and nothing will be written
                            println("Order not verified, please restart ordering system to order")
                        }
                    }
                }
                2 -> if (customer == null) {
                    println("No customer profile detected, launching new customer profile menu")
                    customer = Customer()
                    customer.newCustomerMenu()
                    serializer.objectWriter(customer)
                    val currentOrder = Order(customer)
                    currentOrder.orderingSystem()
                    if (currentOrder.isOrderVerified) {
                        customer.add(currentOrder)
                    } else {
                        println("Order not verified, please restart ordering system to order")
                    }
                } else {
                    val currentOrder = Order(customer)
                    currentOrder.orderingSystem()
                    if (currentOrder.isOrderVerified) {
                        customer.add(currentOrder)
                    } else {
                        println("Order not verified, please restart ordering system to order")
                    }
                }
            }
        } while (runCondition)
    }

    fun mainMenu() {
        println("1: Customer Profile Data")
        println("2: Place New Order")
        println("Any other key to exit")
        //        System.out.println();
//        System.out.println();
    } //    public static int validateInt(){
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