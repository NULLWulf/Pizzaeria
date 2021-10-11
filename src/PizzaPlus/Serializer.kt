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

class Serializer : Serializable {
    //    private Customer customer;
    var customerFile = "customer.txt"
    fun objectWriter(customer: Customer?) {
        println("Saving customer data, please do not close application")
        try {
            val out = ObjectOutputStream(FileOutputStream(customerFile))
            out.writeObject(customer) // causing problem, cant write items in aray directly it seems
            out.close()
            println("Customer data save successful, save to close application")
        } catch (e: FileNotFoundException) {
            println("No Customer File Found, no data has been written")
            e.printStackTrace()
        } catch (e: IOException) {
            println("File Reader error, no customer data has been saved.  See stack trace for details.")
            e.printStackTrace()
        }
    }

    fun objectReader(): Customer? {
        return try {
            val `in` = ObjectInputStream(FileInputStream(customerFile))
            val customer = `in`.readObject() as Customer
            `in`.close()
            println("Found" + customer.firstName + " " + customer.lastName + "'s customer data and imported successfully")
            customer
        } catch (e: FileNotFoundException) {
            println("No Customer File Found, please create new customer file")
            null
        } catch (e: IOException) {
            println("File Reader error, no customer data has been imported.  See stack trace for details.")
            println("See stack track for details")
            e.printStackTrace()
            null
        } catch (e: ClassNotFoundException) {
            println("File found but does not match imported class, no customer data has been imported")
            println("See stack trace for details")
            //e.printStackTrace();
            null
        }
    }
}