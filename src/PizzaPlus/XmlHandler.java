package PizzaPlus;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
public class XmlHandler extends DefaultHandler {

    private ArrayList<Toppings>  toppings = new ArrayList<>();
    Toppings topping;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {}

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {}

    public ArrayList<Toppings> getToppings() {
        return toppings;
    }
}
