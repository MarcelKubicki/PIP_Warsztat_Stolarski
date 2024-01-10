package Model;

import jakarta.persistence.*;

import java.util.List;

public class Klient {

    private long id;
    private String imie;
    private String nazwisko;
    private String adres;
    private String nrTelefonu;

    private List<Faktura> faktury;
}
