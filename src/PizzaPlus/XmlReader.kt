package PizzaPlus

import PizzaPlus.Customer.*
import java.io.File
import java.lang.Exception
import javax.xml.parsers.SAXParserFactory

class XmlReader(private val inputFileName: String) {
    private var toppingXmlHandler: XmlHandler? = null
    private var toppings: Array<Toppings>? = null


    //var itemsOrdered = ArrayList<Pizza?>()

    // Get the ArrayList of Orders built by the handler and return an array
//    val toppingsList: Array<Toppings>
////        get() {
////            // Get the ArrayList of Orders built by the handler and return an array
//////            var list = ArrayList<Toppings>(toppingXmlHandler?.getToppings().size())
//////            list = toppingXmlHandler?.getToppings().toArray(list)
//////            return list
////        }

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