/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parserINS;

import java.io.IOException;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Miriam
 */
public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Konverter kon = new Konverter();
        kon.setEingabedatei("./src/xml-Dateien/Testwagen.xml");
        kon.parseDokument();
        Set<Fahrzeug> fahrzeuge = kon.getFahrzeuge();
        for(Fahrzeug f : fahrzeuge) {
            System.out.println(f.toString());
        }
        kon.setAusgabedatei("./src/xml-Dateien/testtest.xml");
        kon.writeDB();
    }
}
