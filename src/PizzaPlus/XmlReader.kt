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
import java.lang.Exception
import javax.xml.parsers.SAXParserFactory

class XmlReader(private val inputFileName: String) {
    private var toppingXmlHandler: XmlHandler? = null
    private val toppings: Array<Toppings>

    // Get the ArrayList of Orders built by the handler and return an array
    val toppingsList: Array<Toppings?>
        get() {
            // Get the ArrayList of Orders built by the handler and return an array
            var list = arrayOfNulls<Toppings>(toppingXmlHandler.getToppings().size)
            list = toppingXmlHandler.getToppings().toArray(list)
            return list
        }

    init {
        try {
            // Declare a File object
            val inputFile = File(inputFileName)

            // Create a SAX parser factory and parser
            val saxParserFactory = SAXParserFactory.newInstance()
            val saxParser = saxParserFactory.newSAXParser()
            if (inputFileName == "toppings.xml") {
                toppingXmlHandler = XmlHandler()
                saxParser.parse(inputFile, toppingXmlHandler)
            }
        } catch (e: Exception) {
            println("Exception: " + e.message)
        }
    }
}