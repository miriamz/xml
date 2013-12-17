package xmlKonvertierer;

import java.util.Objects;

/**
 *
 * @author Miriam
 */
public class Ausstattungsoption {

    private String bezeichnung;
    private String anzahl;
    private String einzelpreis;

    public Ausstattungsoption() {
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(String anzahl) {
        this.anzahl = anzahl;
    }

    public String getEinzelpreis() {
        return einzelpreis;
    }

    public void setEinzelpreis(String einzelpreis) {
        this.einzelpreis = einzelpreis;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.bezeichnung);
        hash = 13 * hash + Objects.hashCode(this.anzahl);
        hash = 13 * hash + Objects.hashCode(this.einzelpreis);
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
        final Ausstattungsoption other = (Ausstattungsoption) obj;
        if (!Objects.equals(this.bezeichnung, other.bezeichnung)) {
            return false;
        }
        if (!Objects.equals(this.anzahl, other.anzahl)) {
            return false;
        }
        if (!Objects.equals(this.einzelpreis, other.einzelpreis)) {
            return false;
        }
        return true;
    }
    
}
