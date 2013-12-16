package parserINS;

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
public class Konverter {

    private String parser = "org.apache.xerces.parsers.SAXPAarser";
    private String eingabedatei;
    private String ausgabedatei;
    private Set<Fahrzeug> fahrzeuge;

    public String getEingabedatei() {
        return eingabedatei;
    }

    public void setEingabedatei(String eingabedatei) {
        this.eingabedatei = eingabedatei;
    }

    public String getAusgabedatei() {
        return ausgabedatei;
    }

    public void setAusgabedatei(String ausgabedatei) {
        this.ausgabedatei = ausgabedatei;
    }

    public Set<Fahrzeug> getFahrzeuge() {
        return fahrzeuge;
    }

    public void parseDokument() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory fac = SAXParserFactory.newInstance();
        fac.setValidating(true);
        SAXParser pars = fac.newSAXParser();
        Handler handler = new Handler();
        pars.parse(this.eingabedatei, handler);
        this.fahrzeuge = handler.getFahrzeuge();

        for (Fahrzeug f : this.fahrzeuge) {
            System.out.println(f.toString());
        }
    }

    public void writeDB() throws ParserConfigurationException, IOException {
        XmlSchreiber schreiber = new XmlSchreiber(this.ausgabedatei, this.fahrzeuge);
    }
    
    
}
