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
import org.xml.sax.Attributes
import org.xml.sax.SAXException
import org.xml.sax.helpers.DefaultHandler
import java.io.File
import java.util.ArrayList
import javax.xml.parsers.SAXParserFactory

class XmlHandler : DefaultHandler() {
    val toppings = ArrayList<Toppings?>()
    var topping: Toppings? = null
    @Throws(SAXException::class)
    override fun startElement(
        uri: String, localName: String, qName: String,
        attributes: Attributes
    ) {
        if (qName == "topping") {
            topping = Toppings(
                attributes.getValue("name"),
                attributes.getValue("type"),
                attributes.getValue("priceForSmall").toDouble(),
                attributes.getValue("PriceForMedium").toDouble(),
                attributes.getValue("priceForLarge").toDouble()
            )
        }
    }

    @Throws(SAXException::class)
    override fun endElement(uri: String, localName: String, qName: String) {
        if (qName == "topping") {
            toppings.add(topping)
        }
    }
}