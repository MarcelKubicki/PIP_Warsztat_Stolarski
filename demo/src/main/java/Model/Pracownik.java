package Model;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class Pracownik {
    private long id;
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private Date dataZatrudnienia;
    private Date dataZwolnienia = null;
    private double stawka;
    private ZakladStolarski zakladStolarski;

    public Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, String stanowisko, double stawka) {
        Calendar calendar = Calendar.getInstance();
        long currentTimeMillis = calendar.getTimeInMillis();

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.dataZatrudnienia = new Date(currentTimeMillis);
        this.stawka = stawka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id ){
        this.id = id;
    }
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Date getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(Date dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public Date getDataZwolnienia() {
        return dataZwolnienia;
    }

    public void setDataZwolnienia(Date dataZwolnienia) {
        this.dataZwolnienia = dataZwolnienia;
    }

    public double getStawka() {
        return stawka;
    }

    public void setStawka(double stawka) {
        this.stawka = stawka;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", stanowisko='" + stanowisko + '\'' +
                '}';
    }


}

