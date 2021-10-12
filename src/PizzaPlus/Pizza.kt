package PizzaPlus

import java.io.Serializable
import java.util.ArrayList

class Pizza(var basePrice: Double) : Serializable {
    var toppings = ArrayList<Toppings>()
    var pizzaTotal = 0.0
    var customer: Customer? = null
    var currToppings: Array<Toppings>? = null
    var toppingsXml = XmlReader("toppings.xml")
    fun toppingsScroller() {}
//        currToppings = toppingsXml.toppingsList
//        for (i in currToppings!!.indices) {}}  // displays topping, need to fix code

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