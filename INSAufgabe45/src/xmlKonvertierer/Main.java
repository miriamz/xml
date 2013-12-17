package xmlKonvertierer;

import java.io.IOException;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Miriam
 */
public class Main {

    public static void main(String[] args) 
            throws ParserConfigurationException, SAXException, IOException {
        Converter kon = new Converter();
        kon.setInputFile("./src/xmlDateien/testwagen.xml");
        kon.parseDocument();
        Set<Fahrzeug> alleFahrzeuge = kon.getAlleFahrzeuge();

        for (Fahrzeug i : alleFahrzeuge) {
            System.out.println(i.toString());
        }
    }
}
