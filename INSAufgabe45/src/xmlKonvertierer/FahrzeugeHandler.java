package xmlKonvertierer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Miriam
 */
public class FahrzeugeHandler extends DefaultHandler {

    private Set<Fahrzeug> alleFahrzeuge;
    private String currentValue;
    private Fahrzeug fahrzeug;
    private Motor motor;
    private Set<Ausstattungsoption> ausstattungsliste;
    private Ausstattungsoption ausstattungsoption;
    SimpleDateFormat pDatumformat = new SimpleDateFormat("dd-MM-yy");
    private String tmpTag;
    private String tmpMonat;
    private String tmpJahr;

    public FahrzeugeHandler() {
        alleFahrzeuge = new HashSet<>();

    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        currentValue = new String(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes atts) throws SAXException {
        //Beim Start vom Fahrzeug durch <fahrzeug>
        if (localName.equalsIgnoreCase("fahrzeug")) {
            fahrzeug = new Fahrzeug();

        }
        //Bei <motor>
        if (localName.equalsIgnoreCase("motor")) {
            motor = new Motor();
        }
        //Bei <ausstattungsoption>
        if (localName.equalsIgnoreCase("ausstattungsoption")) {
            ausstattungsoption = new Ausstattungsoption();
        }
        //Bei <ausstattungsliste>
        if (localName.equalsIgnoreCase("ausstattungsliste")) {
            ausstattungsliste = new HashSet<>();
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        //fehlenden Hersteller einfügen. 
        if (localName.equalsIgnoreCase("fahrzeug")) {
            fahrzeug.setHersteller("Oldsmobil GmbH & KOKG");
            this.getAlleFahrzeuge().add(fahrzeug);
        }
        //Bei Ende <modellbezeichnung>
        if (localName.equalsIgnoreCase("modellbezeichnung")) {
            fahrzeug.setModellbezeichnung(currentValue);
        }
        //Bei Ende <seriennummer>
        if (localName.equalsIgnoreCase("seriennummer")) {
            fahrzeug.setSeriennummer(currentValue);
        }
        //Bei Ende <farbe>
        if (localName.equalsIgnoreCase("farbe")) {
            fahrzeug.setFarbe(currentValue);
        }
        //Bei Ende <produktionsdatum>
        if (localName.equalsIgnoreCase("produktionsdatum")) {
            Date date = new Date();
            if (this.tmpTag != null
                    && this.tmpMonat != null
                    && this.tmpJahr != null) {
                String tmpDate = this.tmpTag + "-"
                        + this.tmpMonat + "-"
                        + this.tmpJahr;
                try {
                    date = this.pDatumformat.parse(tmpDate);

                } catch (ParseException e) {
                    String error = "Datum parsen ist schief gegangen" + "\n"
                            + e.getMessage();
                    throw new SAXException(error, e);
                }

            } else {
                throw new SAXException("Datum parsen ist schief gegangen");
            }
            this.tmpTag = null;
            this.tmpMonat = null;
            this.tmpJahr = null;
            fahrzeug.setProduktionsdatum(date);
        }
        //Bei Ende <tag>
        if (localName.equalsIgnoreCase("tag")) {
            tmpTag = currentValue;
        }
        //Bei Ende <monat>
        if (localName.equalsIgnoreCase("monat")) {
            tmpMonat = currentValue;
        }
        //Bei Ende <jahr>
        if (localName.equalsIgnoreCase("jahr")) {
            tmpJahr = currentValue;
        }
        //Bei Ende <anmerkung>
        if (localName.equalsIgnoreCase("anmerkung")) {
            fahrzeug.setAnmerkung(currentValue);
        }
        //Bei Ende <motor>
        if (localName.equalsIgnoreCase("motor")) {
            fahrzeug.setMotor(motor);
        }
        //Bei Ende <ausstattungsliste>
        if (localName.equalsIgnoreCase("ausstattungsliste")) {
            fahrzeug.fuegeAOptionenHinzu(ausstattungsliste);
        }
        //Bei Ende <zylinderanzahl>
        if (localName.equalsIgnoreCase("zylinderanzahl")) {
            motor.setZylinderanzahl(currentValue);
        }
        //Bei Ende <brennstoffart>
        if (localName.equalsIgnoreCase("brennstoffart")) {
            motor.setBrennstoffart(currentValue);
        }
        //Bei Ende <hubraum>
        if (localName.equalsIgnoreCase("hubraum")) {
            motor.setHubraum(currentValue);
        }
        if (localName.equalsIgnoreCase("ausstattungsoption")) {
            ausstattungsliste.add(ausstattungsoption);
        }
        //Bei Ende <bezeichnung>
        if (localName.equalsIgnoreCase("bezeichnung")) {
            ausstattungsoption.setBezeichnung(currentValue);
        }
        //Bei Ende <anzahl>
        if (localName.equalsIgnoreCase("anzahl")) {
            ausstattungsoption.setAnzahl(currentValue);
        }
        //Bei Ende <einzelpreis>
        if (localName.equalsIgnoreCase("einzelpreis")) {
            ausstattungsoption.setAnzahl(currentValue);
        }
    }

    public Set<Fahrzeug> getAlleFahrzeuge() {
        return alleFahrzeuge;
    }
}
