package parserINS;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Miriam
 */
public class Handler extends DefaultHandler {

    private String dateinameXml;
    private Set<Fahrzeug> fahrzeuge;
    private String tmpWert;
    private Fahrzeug tmpFahrzeug;
    private Motor tmpMotor;
    private Ausstattung tmpAusstattung;
    private Set<Ausstattung> tmpAustattungen;
    private String tmpTag;
    private String tmpMonat;
    private String tmpJahr;
    SimpleDateFormat tmy = new java.text.SimpleDateFormat("dd-MM-yy");
    private String errorZahl = "Zahl kann nicht geparst werden.";
    private String errorDatum = "Datum kann nicht geparst werden.";
          

    public Handler() {
        this.fahrzeuge = new HashSet<>();
    }

    @Override
    public void startElement(
            String x,
            String xl,
            String elementName,
            Attributes att) throws SAXException {

        if (elementName.equalsIgnoreCase("fahrzeug")) {
            this.tmpFahrzeug = new Fahrzeug();
        }
        if (elementName.equalsIgnoreCase("motor")) {
            this.tmpMotor = new Motor();
        }
        if (elementName.equalsIgnoreCase("austattungsoption")) {
            this.tmpAusstattung = new Ausstattung();
        }
        if (elementName.equalsIgnoreCase("ausstattungsliste")) {
            this.tmpAustattungen = new HashSet<>();
        }
    }

    @Override
    public void endElement(
            String x,
            String xl,
            String elementName) throws SAXException {

        if (elementName.equalsIgnoreCase("fahrzeug")) {
            
            this.tmpFahrzeug.setHersteller("Oldsmobil GmbH & KOKG");
            this.getFahrzeuge().add(this.tmpFahrzeug);
        }
        if (elementName.equalsIgnoreCase("hersteller")) {
            this.tmpFahrzeug.setHersteller(tmpWert);
        }
        if (elementName.equalsIgnoreCase("modellbezeichnung")) {
            this.tmpFahrzeug.setModellbezeichnung(tmpWert);
        }
        if (elementName.equalsIgnoreCase("seriennummer")) {
            long seriennummer = 0;
            try {
                seriennummer = Long.parseLong(tmpWert);
            } catch (NumberFormatException e) {
                String error = errorZahl + "\n" + e.getMessage();
                throw new SAXException(error, e);
            }
            this.tmpFahrzeug.setSeriennummer(seriennummer);
        }


        if (elementName.equalsIgnoreCase("farbe")) {
            this.tmpFahrzeug.setFarbe(tmpWert);
        }
        if (elementName.equalsIgnoreCase("produktionsdatum")) {
            Date datum = new Date();
            if (this.tmpTag != null
                    && this.tmpMonat != null
                    && this.tmpJahr != null) {

                String tmpDatum = this.tmpTag + "-"
                        + this.tmpMonat + "-"
                        + this.tmpJahr;
                try {
                    datum = this.tmy.parse(tmpDatum);
                } catch (ParseException e) {
                    String error = errorDatum + "\n" + e.getMessage();
                    throw new SAXException(error, e);
                }
            } else {
                throw new SAXException(errorDatum);
            }
            this.tmpTag = null;
            this.tmpMonat = null;
            this.tmpJahr = null;
            this.tmpFahrzeug.setProduktionsdatum(datum);

        }
        if (elementName.equalsIgnoreCase("anmerkung")) {
            this.tmpFahrzeug.setAnmerkung(tmpWert);
        }
        if (elementName.equalsIgnoreCase("zylinderanzahl")) {
            int zylinderanzahl = 0;
            try {
                zylinderanzahl = Integer.parseInt(this.tmpWert);
            } catch (NumberFormatException e) {
                String error = errorZahl + "\n" + e.getMessage();
                throw new SAXException(error, e);
            }

            if (elementName.equalsIgnoreCase("brennstoffart")) {
                this.tmpMotor.setBrennstoffart(tmpWert);
            }

            if (elementName.equalsIgnoreCase("hubraum")) {
                int hubraum = 0;
                try {
                    hubraum = Integer.parseInt(this.tmpWert);

                } catch (NumberFormatException e) {
                    String error = errorZahl + "\n" + e.getMessage();
                    throw new SAXException(error, e);
                }
                this.tmpMotor.setHubraum(hubraum);

            }

        }
    }

    public Set<Fahrzeug> getFahrzeuge() {
        return fahrzeuge;
    }

    @Override
    public void characters(char[] ac, int i, int j) throws SAXException {
        tmpWert = new String(ac, i, j);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        String error = "Warning" + e.getMessage();
        throw new SAXException(error, e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        String error = "Error" + e.getMessage();
        throw new SAXException(error, e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        String error = "fatalError" + e.getMessage();
        throw new SAXException(error, e);
    }
}
