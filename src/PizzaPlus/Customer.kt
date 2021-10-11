package PizzaPlus

import PizzaPlus.Order
import java.io.Serializable
import java.util.*

class Customer : Serializable {
    // Getters and Setters
    // Personal Information
    var phoneNumber: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var streetAddress: String? = null
    var city: String? = null
    var state: String? = null
    var zipCode: String? = null

    // Order and Calculated Related Data
    var totalOrderPrice = 0.0
    var orders = ArrayList<Order>()
    fun newCustomerMenu() {  // Customer creation menu
        val scanner = Scanner(System.`in`)
        var profileDone = false
        var selection = 0
        while (!profileDone) {
            print("Enter First Name: ")
            firstName = scanner.nextLine()
            print("Enter Last Name: ")
            lastName = scanner.nextLine()
            print("Enter Street Address: ")
            streetAddress = scanner.nextLine()
            print("Enter City: ")
            city = scanner.nextLine()
            print("Enter State: ")
            state = scanner.nextLine()
            print("Enter City: ")
            zipCode = scanner.nextLine()
            print("Enter City: ")
            println("Is this information correct?")
            displayCustomerInfo()
            println("Enter 1 for yes, anything else to start over")
            selection = scanner.nextInt()
            if (selection == 1) {
                profileDone = true
            }
        }
        scanner.close()
    }

    fun displayCustomerInfo() {
        println("Name: " + firstName + " " + lastName)
        println("Address: " + streetAddress + ", " + city)
        println("State" + state + " Zip: " + zipCode)
    }

    fun add(order: Order) {
        orders.add(order)
        totalOrderPrice = order.total // function may not be necessary
    }
}