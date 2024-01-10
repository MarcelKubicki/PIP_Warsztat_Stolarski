package Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Mebel {
    private long id;
    private String kolor;
    private double szerokosc;
    private double wysokosc;
    private double glebokosc;
    private int ilosc;
    String typMebla;
    private int iloscDrzwiczek;
    private int iloscSzuflad;
    private List<Akcesorium> akcesoria;
    private List<Element> elementy;

    public Mebel(){
        this.akcesoria = new ArrayList<>();
        this.elementy = new ArrayList<>();
    }

    public Mebel(long id, String kolor, double szerokosc, double wysokosc, double glebokosc, int ilosc, String typMebla, int iloscDrzwiczek, int iloscSzuflad) {
        this.id = id;
        this.kolor = kolor;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
        this.glebokosc = glebokosc;
        this.ilosc = ilosc;
        this.typMebla = typMebla;
        this.iloscDrzwiczek = iloscDrzwiczek;
        this.iloscSzuflad = iloscSzuflad;
        this.akcesoria = new ArrayList<>();
        this.elementy = new ArrayList<>();

    }

    public long getId() {
        return id;
    }

    public String getKolor() {
        return kolor;
    }

    public double getSzerokosc() {
        return szerokosc;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public double getGlebokosc() {
        return glebokosc;
    }

    public int getIlosc() {
        return ilosc;
    }

    public List<Akcesorium> getAkcesoria() {
        return akcesoria;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public void setSzerokosc(double szerokosc) {
        this.szerokosc = szerokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public void setGlebokosc(double glebokosc) {
        this.glebokosc = glebokosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public void setAkcesoria(List<Akcesorium> akcesoria) {
        this.akcesoria = akcesoria;
    }

    public String getTypMebla() {
        return typMebla;
    }

    public void setTypMebla(String typMebla) {
        this.typMebla = typMebla;
    }

    public List<Element> getElementy() {
        return elementy;
    }

    public void setElementy(List<Element> elementy) {
        this.elementy = elementy;
    }

    public int getIloscDrzwiczek() {
        return iloscDrzwiczek;
    }

    public int getIloscSzuflad() {
        return iloscSzuflad;
    }

    public void setIloscDrzwiczek(int iloscDrzwiczek) {
        this.iloscDrzwiczek = iloscDrzwiczek;
    }

    public void setIloscSzuflad(int iloscSzuflad) {
        this.iloscSzuflad = iloscSzuflad;
    }

    @Override
    public String toString() {
        return "Mebel{" +
                "id=" + id +
                ", kolor='" + kolor + '\'' +
                ", szerokosc=" + szerokosc +
                ", wysokosc=" + wysokosc +
                ", glebokosc=" + glebokosc +
                ", ilosc=" + ilosc +
                ", akcesoria=" + akcesoria +
                '}';
    }

    public double obliczObjetosc(){
        return szerokosc * wysokosc * glebokosc;
    }
    private void obliczElementy(){
        elementy.add(new Element("plyta", kolor, 2, glebokosc, wysokosc));//boki
        elementy.add(new Element("plyta", kolor, 1, szerokosc, glebokosc));//spod
        elementy.add(new Element("HDF", kolor, 1, szerokosc, wysokosc));//plecy
        if(iloscDrzwiczek > 0){
            elementy.add(new Element("front", kolor, iloscDrzwiczek, szerokosc/iloscDrzwiczek, wysokosc));//drzwiczki
            elementy.add(new Element("plyta", kolor, (int)wysokosc%25,szerokosc, glebokosc));//polki
            akcesoria.add(new Akcesorium("zawiasy", iloscDrzwiczek*2));//zawiasy
        } else if (iloscSzuflad > 0) {
            elementy.add(new Element("front", kolor, iloscSzuflad, szerokosc, wysokosc/iloscSzuflad));//front szuflady
            elementy.add(new Element("plyta", kolor, 2*iloscSzuflad, glebokosc, (wysokosc/iloscSzuflad)*0.75));//boki szuflady
            elementy.add(new Element("plyta", kolor, iloscSzuflad, szerokosc, glebokosc));//spod szuflady
            elementy.add(new Element("plyta", kolor, iloscSzuflad, szerokosc, (wysokosc/iloscSzuflad)*0.75));//tyl szuflady
            akcesoria.add(new Akcesorium("prowadnica", iloscSzuflad*2));// prowadnice
        }
    }
    public void obliczMaterial(){
        if (typMebla != null && typMebla.contains("stojaca") && typMebla.contains("kuchenna")) {
            setWysokosc(wysokosc-=8);
            elementy.add(new Element("plyta", kolor, 2, szerokosc, glebokosc/4));//gora
            akcesoria.add(new Akcesorium("nozki", 4));//nozki
            obliczElementy();
        } else {
            elementy.add(new Element("plyta", kolor, 1, szerokosc, glebokosc));//gora
            obliczElementy();
        }
    }
}
