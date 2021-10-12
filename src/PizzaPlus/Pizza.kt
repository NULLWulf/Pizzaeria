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
import java.util.ArrayList
import javax.xml.parsers.SAXParserFactory

class Pizza(var basePrice: Double) : Serializable {
    var toppings = ArrayList<Toppings>()
    var pizzaTotal = 0.0
    var customer: Customer? = null
    var currToppings: Array<Toppings>? = null
    var toppingsXml = XmlReader("toppings.xml")
    fun toppingsScroller() {
        currToppings = toppingsXml.toppingsList
        for (i in currToppings!!.indices) {}}  // displays topping, need to fix code

    fun add(topping: Toppings) {
        toppings.add(topping)
        pizzaTotal += topping.toppingPrice
    }

//    companion object {
//        var pie12 = 12.00
//        var pie14 = 14.00
//        var pie16 = 16.00
//    }
}