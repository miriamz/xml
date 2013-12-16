package parserINS;

/**
 *
 * @author Miriam
 */
public class Motor {

    private int zylinderanzahl;
    private String brennstoffart;
    private int hubraum;

    public Motor() {
        this.zylinderanzahl = 0;
        this.brennstoffart = null;
        this.hubraum = 0;
    }

    public Motor(int zylinderanzahl, String brennstoffart, int hubraum) {
        this.zylinderanzahl = zylinderanzahl;
        this.brennstoffart = brennstoffart;
        this.hubraum = hubraum;
    }

    public int getZylinderanzahl() {
        return zylinderanzahl;
    }

    public void setZylinderanzahl(int zylinderanzahl) {
        this.zylinderanzahl = zylinderanzahl;
    }

    public String getBrennstoffart() {
        return brennstoffart;
    }

    public void setBrennstoffart(String brennstoffart) {
        this.brennstoffart = brennstoffart;
    }

    public int getHubraum() {
        return hubraum;
    }

    public void setHubraum(int hubraum) {
        this.hubraum = hubraum;
    }
}
