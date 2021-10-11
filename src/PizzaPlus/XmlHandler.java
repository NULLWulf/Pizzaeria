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
                             Attributes attributes) throws SAXException {
        if (qName.equals("topping")){
            topping = new Toppings(attributes.getValue("name"), attributes.getValue("type"), Double.parseDouble(attributes.getValue("priceForSmall")),Double.parseDouble(attributes.getValue("PriceForMedium")),
                    Double.parseDouble(attributes.getValue("priceForLarge")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("topping")){
            toppings.add((topping));
        }
    }

    public ArrayList<Toppings> getToppings() {
        return toppings;
    }
}
