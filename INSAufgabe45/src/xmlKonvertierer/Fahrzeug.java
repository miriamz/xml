package xmlKonvertierer;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Miriam
 */
public class Fahrzeug {

    private String hersteller;
    private String modellbezeichnung;
    private String seriennummer;
    private String farbe;
    private Date produktionsdatum;
    private String anmerkung;
    private Motor motor;
    private Set<Ausstattungsoption> ausstattungsliste;

    public Fahrzeug() {
        this.ausstattungsliste = new HashSet<>();
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getModellbezeichnung() {
        return modellbezeichnung;
    }

    public void setModellbezeichnung(String modellbezeichnung) {
        this.modellbezeichnung = modellbezeichnung;
    }

    public String getSeriennummer() {
        return seriennummer;
    }

    public void setSeriennummer(String seriennummer) {
        this.seriennummer = seriennummer;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public Date getProduktionsdatum() {
        return produktionsdatum;
    }

    public void setProduktionsdatum(Date produktionsdatum) {
        this.produktionsdatum = produktionsdatum;
    }

    public String getAnmerkung() {
        return anmerkung;
    }

    public void setAnmerkung(String anmerkung) {
        this.anmerkung = anmerkung;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Set<Ausstattungsoption> getAusstattungsliste() {
        return ausstattungsliste;
    }

    public void setAusstattungsliste(Set<Ausstattungsoption> ausstattungsliste) {
        this.ausstattungsliste = ausstattungsliste;
    }
    public void fuegeAOptionenHinzu(Set<Ausstattungsoption> ausstattungsliste) {
        this.ausstattungsliste.addAll(ausstattungsliste);
    }

    @Override
    public String toString() {
        return "Fahrzeug (" + "Hersteller: " + this.hersteller + "\n"
                + "Modellbezeichnung: " + this.modellbezeichnung + "\n"
                + "Seriennumer: " + this.seriennummer + " \n"
                + "Farbe: " + this.farbe
                + "Produktionsdatum: " + this.produktionsdatum + "\n";

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.hersteller);
        hash = 67 * hash + Objects.hashCode(this.seriennummer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fahrzeug other = (Fahrzeug) obj;
        if (!Objects.equals(this.hersteller, other.hersteller)) {
            return false;
        }
        if (!Objects.equals(this.seriennummer, other.seriennummer)) {
            return false;
        }
        return true;
    }
}
