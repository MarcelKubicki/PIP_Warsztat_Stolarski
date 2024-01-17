package Model;

public class Element {
    private String typ;
    private String kolor;
    private int ilosc;
    private double szerokosc;
    private double wysokosc;
    private double grubosc = 1.5;

    public Element(String typ, String kolor, int ilosc, double szerokosc, double wysokosc) {
        this.typ = typ;
        this.kolor = kolor;
        this.ilosc = ilosc;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }
    public Element(String typ, String kolor, int ilosc, double szerokosc, double wysokosc, double grubosc) {
        this.typ = typ;
        this.kolor = kolor;
        this.ilosc = ilosc;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.grubosc = grubosc;
    }

    public String getTyp() {
        return typ;
    }

    public String getKolor() {
        return kolor;
    }

    public int getIlosc() {
        return ilosc;
    }

    public double getSzerokosc() {
        return szerokosc;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public double getGrubosc() {
        return grubosc;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public void setSzerokosc(double szerokosc) {
        this.szerokosc = szerokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public void setGrubosc(double grubosc) {
        this.grubosc = grubosc;
    }

    @Override
    public String toString() {
        return "Element{" +
                "typ='" + typ + '\'' +
                ", kolor='" + kolor + '\'' +
                ", ilosc=" + ilosc +
                ", szerokosc=" + szerokosc +
                ", wysokosc=" + wysokosc +
                ", grubosc=" + grubosc +
                '}';
    }
}

