package parserINS;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Miriam
 */
public class XmlSchreiber {

    private String systemID = "./src/xml-Dateien/NewWaveRacerDTD.dtd";
    private Set<Fahrzeug> fahrzeuge;
    private Document doc;
    private String outputFile;

    public XmlSchreiber(String oFPath, Set<Fahrzeug> inFahrzeuge)
            throws ParserConfigurationException, IOException {

        this.outputFile = oFPath;
        this.fahrzeuge = inFahrzeuge;

        DocumentBuilderFactory xyz = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = xyz.newDocumentBuilder();

        this.doc = db.newDocument();
        this.erzeugeDOMTree();
        this.fuegeZurDatei();
    }

    private void fuegeZurDatei() throws IOException {
        OutputFormat format = new OutputFormat(doc);
        format.setDoctype(null, systemID);
        format.setIndenting(true);

        FileOutputStream fos = new FileOutputStream(new File(this.outputFile));
        XMLSerializer seri = new XMLSerializer(fos, format);
    }

    private void erzeugeDOMTree() {
        DOMImplementation domImpl = doc.getImplementation();
        DocumentType doctype = domImpl.createDocumentType(
                "fahrzeugdatenbank",
                null,
                systemID);
        doc.appendChild(doctype);

        //create the root element
        Element rootElement = doc.createElement("fahrzeugdatenbank");
        doc.appendChild(rootElement);

        for (Fahrzeug i : this.fahrzeuge) {
            Element vehicleElement = erzeugeFahrzeugElement(i);
            rootElement.appendChild(vehicleElement);
        }
    }

    private Element erzeugeFahrzeugElement(Fahrzeug fahrzeug) {
        Element fahrzeugElement = doc.createElement("fahrzeug");

        fahrzeugElement.setAttribute("color", fahrzeug.getFarbe());
        fahrzeugElement.setAttribute("hersteller", fahrzeug.getHersteller());
        fahrzeugElement.setAttribute("modellbezeichnung", fahrzeug.getModellbezeichnung());
        fahrzeugElement.setAttribute("seriennumer", "" + fahrzeug.getSeriennummer());

        fahrzeugElement.appendChild(this.erzeugeDatumElement(fahrzeug.getProduktionsdatum()));
        fahrzeugElement.appendChild(this.erzeugeAnmerkungElement(fahrzeug.getAnmerkung()));
        fahrzeugElement.appendChild(this.erzeugeMotorElement(fahrzeug.getMotor()));
        fahrzeugElement.appendChild(this.erzeugeAusstattungenElement(fahrzeug.getAusstattung()));

        return fahrzeugElement;
    }

    private Element erzeugeDatumElement(Date inDate) {
        Element dopElement = doc.createElement("produktionsdatum");
        SimpleDateFormat tmy = new SimpleDateFormat("dd-MM-yy");
        String date = tmy.format(inDate);
        String[] dateToken = date.split("-");

        dopElement.setAttribute("tag", dateToken[0]);
        dopElement.setAttribute("monat", dateToken[1]);
        dopElement.setAttribute("tag", dateToken[2]);

        return dopElement;
    }

    private Element erzeugeAnmerkungElement(String anmerkung) {
        Element anmerkungElement = doc.createElement(("anmerkung"));

        Text anmerkungText = doc.createTextNode(anmerkung);
        anmerkungElement.appendChild(anmerkungText);

        return anmerkungElement;

    }

    private Element erzeugeMotorElement(Motor motor) {
        Element motorElement = doc.createElement("motor");

        motorElement.setAttribute("zylinderanzahl", "" + motor.getZylinderanzahl());
        motorElement.setAttribute("brennstoffart", motor.getBrennstoffart());
        motorElement.setAttribute("hubraum", "" + motor.getHubraum());

        return motorElement;
    }

    private Element erzeugeAusstattungenElement(Set<Ausstattung> ausstattungen) {

        Element ausstattungenElement = doc.createElement("ausstattungsliste");
        for (Ausstattung a : ausstattungen) {
            ausstattungenElement.appendChild(erzeugeAusstattungElement(a));
        }

        return ausstattungenElement;

    }

    private Element erzeugeAusstattungElement(Ausstattung ausstattung) {
        Element ausstattungElement = doc.createElement(("ausstattungsoption"));

        ausstattungElement.setAttribute("einzelpreis", "" + ausstattung.getEinzelpreis());
        ausstattungElement.setAttribute("bezeichnung", ausstattung.getBezeichnung());
        ausstattungElement.setAttribute("anzahl", "" + ausstattung.getAnzahl());

        return ausstattungElement;
    }
}
