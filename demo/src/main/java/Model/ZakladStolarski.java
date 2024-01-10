package Model;

import jakarta.persistence.*;

import java.util.List;

public class ZakladStolarski {

    private long id;
    private String adres;

    private List<Magazyn> magazyny;

    private List<Pracownik> pracownicy;

    private List<Faktura> faktury;
}
