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

