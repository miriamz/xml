package xmlKonvertierer;

import java.io.IOException;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Miriam
 */
public class Converter {

    private String inputFile;
    private Set<Fahrzeug> alleFahrzeuge;

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public Set<Fahrzeug> getAlleFahrzeuge() {
        return alleFahrzeuge;
    }

    public void setAlleFahrzeuge(Set<Fahrzeug> alleFahrzeuge) {
        this.alleFahrzeuge = alleFahrzeuge;
    }

    public void parseDocument()
            throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();

        factory.setValidating(true);

        SAXParser parser = factory.newSAXParser();

        FahrzeugeHandler handler = new FahrzeugeHandler();

        parser.parse(inputFile, handler);

        alleFahrzeuge = handler.getAlleFahrzeuge();

        for (Fahrzeug i : alleFahrzeuge) {
            System.out.println(i.toString());
        }
    }
}
