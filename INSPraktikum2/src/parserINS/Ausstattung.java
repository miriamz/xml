package parserINS;

/**
 *
 * @author Miriam
 */
public class Ausstattung {

    private String bezeichnung;
    private int anzahl;
    private float einzelpreis;

    public Ausstattung() {
        this.bezeichnung = null;
        this.anzahl = 0;
        this.einzelpreis = 0;

    }

    public Ausstattung(String bezeichnung, int anzahl, float einzelpreis) {
        this.bezeichnung = bezeichnung;
        this.anzahl = anzahl;
        this.einzelpreis = einzelpreis;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public float getEinzelpreis() {
        return einzelpreis;
    }

    public void setEinzelpreis(float einzelpreis) {
        this.einzelpreis = einzelpreis;
    }
}
