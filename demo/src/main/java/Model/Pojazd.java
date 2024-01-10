package Model;

import Model.Mebel;

import java.util.ArrayList;
import java.util.List;

public class Pojazd {
    private String numerRejestracyjny;
    private String marka;
    private String model;
    private double spalanie;
    private double ladownosc;
    private List<Mebel> przewozoneMeble;

    public Pojazd(String numerRejestracyjny, String marka, String model, double spalanie, double ladownosc) {
        this.numerRejestracyjny = numerRejestracyjny;
        this.marka = marka;
        this.model = model;
        this.spalanie = spalanie;
        this.ladownosc = ladownosc;
        this.przewozoneMeble = new ArrayList<>();
    }

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }
    public void setNumerRejestracyjny(String numerRejestracyjny){
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public double getLadownosc() {
        return ladownosc;
    }
    public void setLadownosc(double ladownosc){
        this.ladownosc = ladownosc;
    }
    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public double getSpalanie() {
        return spalanie;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpalanie(double spalanie) {
        this.spalanie = spalanie;
    }

    public void setPrzewozoneMeble(List<Mebel> przewozoneMeble) {
        this.przewozoneMeble = przewozoneMeble;
    }

    public List<Mebel> getPrzewozoneMeble() {
        return przewozoneMeble;
    }

    public void dodajMeble(Mebel mebel) {
        if (mozePrzewiezc(mebel)) {
            przewozoneMeble.add(mebel);
            System.out.println("Dodano meble do pojazdu.");
        } else {
            System.out.println("Pojazd nie ma wystarczającej ładowności.");
        }
    }

    public boolean mozePrzewiezc(Mebel mebel) {
        return ladownosc >= mebel.obliczObjetosc();
    }

    @Override
    public String toString() {
        return "MeblePojazd{" +
                "numerRejestracyjny='" + numerRejestracyjny + '\'' +
                ", ladownosc=" + ladownosc +
                ", przewozoneMeble=" + przewozoneMeble +
                '}';
    }
}
