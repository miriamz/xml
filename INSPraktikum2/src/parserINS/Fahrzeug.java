package parserINS;

import java.util.Date;
import java.util.Set;

/**
 *.
 *
 * @author Miriam
 */
public class Fahrzeug {

    private String hersteller;
    private String modellbezeichnung;
    private long seriennummer;
    private String farbe;
    private String anmerkung;
    private Date produktionsdatum;
    private Motor motor;
    private Set<Ausstattung> ausstattung;

    public Fahrzeug() {
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

    public long getSeriennummer() {
        return seriennummer;
    }

    public void setSeriennummer(long seriennummer) {
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

    public Set<Ausstattung> getAusstattung() {
        return ausstattung;
    }

    public void setAusstattung(Set<Ausstattung> ausstattung) {
        this.ausstattung = ausstattung;
    }

    @Override
    public String toString() {
        return "Hersteller=" + getHersteller() + "/n"
                + "Modellbezeichnung=" + getModellbezeichnung() + "/n"
                + "Seriennummer=" + getSeriennummer() + "/n"
                + "Farbe=" + getFarbe() + "/n";
    }
}
