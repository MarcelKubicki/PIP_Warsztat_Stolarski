package Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Entity
@NamedQuery(name = "Pracownik.all", query = "SELECT p FROM Pracownik p")
@NamedQuery(name = "Pracownik.byId", query = "SELECT p FROM Pracownik p WHERE id =  :proacownikId")
@NamedQuery(name = "Pracownik.byImie", query = "SELECT p FROM Pracownik p WHERE imie =  :imie")
@NamedQuery(name = "Pracownik.byNazwisko", query = "SELECT p FROM Pracownik p WHERE nazwisko = :nazwisko")
@NamedQuery(name = "Pracownik.byImieNazwisko", query = "SELECT p FROM Pracownik p WHERE id =  :imie AND nazwisko = :nazwisko")
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String imie;
    private String nazwisko;
    private String stanowisko;
    private Date dataZatrudnienia;
    private Date dataZwolnienia;
    private double stawka;

    @ManyToOne
    @JoinColumn(name = "zakladStolarski_id")
    private ZakladStolarski zakladStolarski;
    @OneToMany(mappedBy = "pracownik", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Faktura> faktury;


    public Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, String stanowisko, double stawka) {
        Calendar calendar = Calendar.getInstance();
        long currentTimeMillis = calendar.getTimeInMillis();

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.dataZatrudnienia = new Date(currentTimeMillis);
        this.dataZwolnienia = null;
        this.stawka = stawka;
    }

    public Long getId() {
        return id;
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
        return "Employee{" +
                "id=" + id +
                ", name='" + imie + '\'' +
                ", surname='" + nazwisko + '\'' +
                ", position='" + stanowisko + '\'' +
                '}';
    }
}

