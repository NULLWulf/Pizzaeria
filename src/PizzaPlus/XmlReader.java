package PizzaPlus;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class XmlReader {
    private final String inputFileName;
    private XmlHandler toppingXmlHandler;
    private Toppings[] toppings;

    public XmlReader(String inputFileName) {
        this.inputFileName = inputFileName;

        try {
            // Declare a File object
            File inputFile = new File(inputFileName);

            // Create a SAX parser factory and parser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            if (inputFileName.equals("toppings.xml")){
                toppingXmlHandler = new XmlHandler();
                saxParser.parse(inputFile, toppingXmlHandler);
            }

        } catch (Exception e) {

            System.out.println("Exception: " + e.getMessage());

        }
    }

    public Toppings[] getToppingsList(){
        // Get the ArrayList of Orders built by the handler and return an array
        Toppings[] list = new Toppings[toppingXmlHandler.getToppings().size()];
        list = toppingXmlHandler.getToppings().toArray(list);
        return list;
    }
}
