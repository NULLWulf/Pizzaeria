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
import java.io.Serializable
import javax.xml.parsers.SAXParserFactory

class Toppings(
    var toppings: String,
    var type: String,
    var priceforSmall: Double,
    var priceforMedium: Double,
    var priceforLarge: Double
) : Serializable {
    var quantityOunces = 0
    var toppingPrice = 0.0

}