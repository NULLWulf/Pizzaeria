package PizzaPlus

import PizzaPlus.Customer.*
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
import java.io.Serializable
import java.util.*
import javax.xml.parsers.SAXParserFactory

class Order(var customer: Customer) : Serializable {
    var itemsOrdered = ArrayList<Pizza?>()
    var isOrderVerified = false
    var total = 0.0
        private set
    val items: Array<Pizza?>?
        get() {
            var listArray = arrayOfNulls<Pizza>(itemsOrdered.size)
            listArray = itemsOrdered.toArray(listArray) as Array<Pizza?>
            return listArray
        }

    fun addItem(pizza: Pizza) {
        itemsOrdered.add(pizza)
        total = pizza.pizzaTotal + total
    }

    fun orderingSystem() {
        val scanner = Scanner(System.`in`)
        println("Welcome to the ordering systems, currently we only have pizzas")
        var pizzaFinished = false
        var orderFinished: Boolean // maintains the multi ordering loop
        var selection: Int
        do {  // will stay in loop so long as user wishes to continue to add pizzas
            do {  // stays in loop while working currnet pizza
                println("Select a Pizza size, 1 for 12, 2 for 14, 3 for 16.  Units are in inches")
                selection = scanner.nextInt() // grabs pizza size selection
                var currentPizza: Pizza?
                currentPizza = when (selection) {
                    1 -> Pizza(12.00)
                    2 -> Pizza(14.00)
                    3 -> Pizza(16.00)
                    else -> null // needed to rid of erors, may swithc if to if else statement
                }
                println("Does this pizza look correct?")
                println("Enter 1 to confirm, 2 to restart pizza")
                selection = scanner.nextInt()
                if (selection == 1) {  // if pizza is confirmed pizza will be added to arraylist of pizzas
                    // may also include other items down the road
                    pizzaFinished = true
                    itemsOrdered.add(currentPizza)
                }
            } while (!pizzaFinished)

            // Prompts to order additional pizzas, if not wanting to oder additional pizzas loop will break
            println("Order additional pizzas?")
            println("Enter 1 to confirm, 2 to go to checkout")
            selection = scanner.nextInt()
            orderFinished = if (selection == 1) {
                false
            } else {
                true
            }
        } while (!orderFinished)

        // Final verification of order process, if correct updates class variable to order verified for use in
        // main function, if not verified order will be completely cleared and user will have to restart
        // todo more elegants solutions on this
        println("Does this order look correct?")
        println("Press 1 to confirm, 2 to completely restart order")
        selection = scanner.nextInt()
        if (selection == 1) {
            isOrderVerified = true // updates class varialbe to true for use in main function
        } else {
            itemsOrdered.clear() // clears array of pizzas
            println("Order list completely restarted, please place order again")
            isOrderVerified = false
        }
    }

    fun toppingsScroll() {}
}